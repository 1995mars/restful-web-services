package com.mars.rest.webservices.restfulwebservices.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data // Lombok,
@Component // Là 1 spring bean
@PropertySource("classpath:config.yml") // Đánh dấu để lấy config từ trong file config.yml
@ConfigurationProperties(prefix = "mars") // Chỉ lấy các config có tiền tố là "mars"
public class FirebaseConfig {
    private String email;
    private String googleAnalyticsId;

    // standard getters and setters
}