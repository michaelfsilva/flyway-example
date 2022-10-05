package com.example.flywayExample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket getApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(Collections.singletonList(getSecuritySchemes()))
        .securityContexts(Collections.singletonList(securityContext()));
  }

  private SecurityScheme getSecuritySchemes() {
    return new BasicAuth("basicAuth");
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder().forPaths(regex("/*.*")).build();
  }
}
