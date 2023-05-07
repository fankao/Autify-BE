package com.autify.be;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContext;
import java.util.List;

@SpringBootApplication
public class AutifyBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutifyBeApplication.class, args);
    }

    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        Server server = new Server().url(servletContext.getContextPath());
        return new OpenAPI()
                .servers(List.of(server));
    }
}
