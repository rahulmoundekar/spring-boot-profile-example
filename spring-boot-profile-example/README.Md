# Spring Boot Profiles :

Spring Profiles provide a way to segregate parts of your application configuration and make it be available only in certain environments.

You can use a spring.profiles.active Environment property to specify which profiles are active.you could include it in your application.properties, as shown in the following example:
 ```java
 spring.profiles.active=dev
 ```
#### Project Setup

  - Making the project by using initializer:
    ```
    https://start.spring.io/
    ```
  - applicaiton.properties: add some configuration like :
    ```java
    # spring.profiles.active=prod
    spring.profiles.active=dev
    server.port=8085
    
    basic.message=hello spring boot profile
    ```
    
  - create 2 more application.properties like:
    ```java
    application-dev.properties
    application-prod.properties
    ```
 - you could include it in your application.properties, as shown in the following example but this is static way:
     ```java
     spring.profiles.active=dev
     ```
  - create controller for expose the url :
    ```java
    
        package com.app.controller;
        
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        
        @RestController
        public class ProfileController {
        
        	@Value("${basic.message}")
        	private String message;
        
        	@RequestMapping("/")
        	public String viewProfile() {
        		return message;
        	}
        
        }
    
    ```
     
  - if you want to dynamic way then your could like to create profile classes like as below :
    ```java
        package com.app.profiles;

        import javax.annotation.PostConstruct;
        
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Profile;
        
        @Profile(value = { "prod" })
        @Configuration
        public class ProdProfile {
        
        	@PostConstruct
        	public void test() {
        		System.out.println("Loaded Production environment");
        	}
        
        }
        ------
        package com.app.profiles;

        import javax.annotation.PostConstruct;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Profile;
        
        @Profile(value = { "dev" })
        @Configuration
        public class DevProfile {
        
        	@PostConstruct
        	public void test() {
        		System.out.println("Loaded DEV environment");
        	}
        
        }
    ```
  - run on your Postman
    * You should run default configuration: http://localhost:8085/
    * you should run Dev Profile: http://localhost:8090/
    * you should run Prod Profile: http://localhost:8080/