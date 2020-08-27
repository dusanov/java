# Mastering-Microservices-with-Java

[Mastering Microservices with Java] (https://www.packtpub.com/application-development/mastering-microservices-java?utm_source=github&utm_medium=repository&utm_campaign=9781785285172) by Packt Publishing

## Code testing requirements

### Chapter 2 

* Software: Netbeans with Java, Maven, Spring Boot
* Hardware: Any system with minimum 2 GB RAM
* OS: Any OS (Linux/Windows/Mac)

To run:
mvn spring-boot:run

### Chapter 3 

* Software: Netbeans with Java
* Hardware: Any system with minimum 2 GB RAM
* OS: Any OS (Linux/Windows/Mac)

To run:
mvn exec:java -Dexec.mainClass="com.packtpub.mmj.domain.RestaurantApp"

### Chapter 4 

* Software: Netbeans with Java, Maven, Spring Cloud, Eureka Server
* Hardware: Any system with minimum 2 GB RAM
* OS: Any OS (Linux/Windows/Mac)

To run:
 - mvn clean install
 - java -jar ./eureka-service/target/eureka-service.jar &
 - java -jar ./restaurant-service/target/restaurant-service.jar &
 - java -jar ./user-service/target/user-service.jar &
 - java -jar ./booking-service/target/booking-service.jar &
 - After booting Eureka service, server can be found at http://localhost:8761/

### Chapter 5

* Software: Netbeans with Java, Maven, Spring Cloud, Eureka Server, Docker, CI/CD App
* Hardware: Any system with minimum 2 GB RAM
* OS: Any OS (Linux/Windows/Mac)

## Related Java Products

* [Java EE Development with NetBeans 7 [Video]] (https://www.packtpub.com/application-development/java-ee-development-netbeans-7-video?utm_source=github&utm_medium=repository&utm_campaign=9781782162469)
* [Java EE 7 with GlassFish 4 Application Server] (https://www.packtpub.com/application-development/java-ee-7-glassfish-4-application-server?utm_source=github&utm_medium=repository&utm_campaign=9781782176886)
* [Java EE 7 First Look] (https://www.packtpub.com/application-development/java-ee-7-first-look?utm_source=github&utm_medium=repository&utm_campaign=9781849699235)



