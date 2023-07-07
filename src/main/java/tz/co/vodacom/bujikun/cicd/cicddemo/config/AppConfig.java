package tz.co.vodacom.bujikun.cicd.cicddemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Configuration
public class AppConfig {

    @Bean
    public WebMvcConfigurer webMvc(){
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://3.84.220.60/")
                        .allowedMethods("GET")
                        .allowedHeaders("*")
                        .maxAge(10);
            }
        };
    }
}
