package com.toy.board.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenAPI openAPI() {
      return new OpenAPI()
              .components(new Components())
              .info(apiInfo());
  }

  private Info apiInfo() {
      return new Info()
              .title("Spring Boot REST API Specifications")
              .description("Specification")
              .version("1.0.0");
  }
}
