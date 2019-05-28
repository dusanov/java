package me.dusanov.btcprofit.svc;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import java.io.*;
import java.net.*;

import org.springframework.http.converter.json.*;
import org.springframework.http.*;
import org.springframework.http.converter.*; 

@RestController
public class BtcProfitSvc {

	private static final String template = "Hello, profit for last 30 days could have been:  %s!";
	private final AtomicLong counter = new AtomicLong();
    	
	private static final Logger log = LoggerFactory.getLogger(BtcProfitSvc.class);

	@RequestMapping("/greeting")
    	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
      
		try {

			RestTemplate restTemplate = new RestTemplate();

			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
   			//Add the Jackson Message converter
   			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
   			// Note: here we are making this converter to process any kind of response, 
   			// not only application/*json, which is the default behaviour
   			converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
   			messageConverters.add(converter);  
   			restTemplate.setMessageConverters(messageConverters); 

        		BtcResult bpiresult = restTemplate.getForObject("https://api.coindesk.com/v1/bpi/historical/close.json", BtcResult.class);
        		log.info(bpiresult.toString());
		
		}catch(Exception e){
			log.error("+ there was an error : ",e);
		}
		
		return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    	}

	class Greeting {

 		private final long id;
   		private final String content;

   		public Greeting(long id, String content) {
       			this.id = id;
        		this.content = content;
    		}

    		public long getId() {
        		return id;
    		}

    		public String getContent() {
        		return content;
    		}
	}



}

