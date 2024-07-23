package com.gof.designpatterns.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Restaurante Gang of Forks")
                        .description("Seja muito bem-vindo ao restaurante Gang of Forks!")
                        .contact(new Contact().name("Marcoantt"))
                        .version("1.0"));
    }
}
