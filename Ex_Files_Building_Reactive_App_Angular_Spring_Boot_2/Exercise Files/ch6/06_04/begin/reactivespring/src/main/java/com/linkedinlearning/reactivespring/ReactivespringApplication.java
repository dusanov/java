package com.linkedinlearning.reactivespring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication(exclude = MongoReactiveDataAutoConfiguration.class)
public class ReactivespringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactivespringApplication.class, args);
    }

}
