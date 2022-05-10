package com.mars.rest.webservices.restfulwebservices.config;

import com.mars.rest.webservices.restfulwebservices.model.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Password {

    @Bean
    public String testBean(){
        System.out.println("Test111");
        return "@Configuration - @Bean";
    }

    public String test1(){
        return "@Configuration - @Bean";
    }


}
