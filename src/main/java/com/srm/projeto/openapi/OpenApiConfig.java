package com.srm.projeto.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {


    @Value("${server.servlet.context-path:/api/v1}")
    private String contextPath;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Conversão de Moedas do Reino SRM")
                        .description("API para gerenciar conversões entre Ouro Real e Tibar")
                        .version("1.0.0"))
                .servers(List.of(
                        new Server().url(contextPath).description("Servidor principal")
                ));
    }

}