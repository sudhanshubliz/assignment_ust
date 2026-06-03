package com.ust.capstone.processing.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI processingServiceOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Processing Service API")
                        .version("1.0")
                        .description("Processing Service consumes order-events and publishes order-status-events. REST endpoints are limited to health and OpenAPI documentation."))
                .servers(List.of(new Server().url("http://localhost:9003").description("Processing Service")));
    }
}
