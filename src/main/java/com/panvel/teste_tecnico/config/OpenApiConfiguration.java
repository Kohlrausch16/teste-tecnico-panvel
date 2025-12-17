package com.panvel.teste_tecnico.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

// Configurando o Swagger da aplicação
@Configuration
@OpenAPIDefinition(info = @Info( title = "API teste técnico", description = "Teste técnico Panvel"))
public class OpenApiConfiguration {


}
