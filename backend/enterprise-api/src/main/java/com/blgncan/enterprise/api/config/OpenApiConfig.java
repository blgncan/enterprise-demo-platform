package com.blgncan.enterprise.api.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI enterpriseApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Enterprise Demo Platform API")
                                .description("Enterprise REST API built with Spring Boot")
                                .version("1.0")
                                .contact(
                                        new Contact()
                                                .name("Bilgin Can")
                                                .email("blgncan@gmail.com")
                                )
                );
    }
}
