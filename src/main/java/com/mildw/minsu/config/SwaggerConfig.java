package com.mildw.minsu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//@Profile("!" + SpringProfiles.KR_PRODUCTION)
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String API_DOC_TITLE = "MINSU";
    private static final String API_DOC_DESCRIPTION = "MINSU REST API DOCUMENTATION";
    private static final String API_DOC_VERSION = "1.0.0";
    private static final String API_DOC_LICENSE = "Apache License Version 2.0";
    private static final String API_DOC_LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";

    // http://localhost:8080/swagger-ui.html
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.midasin.aicc"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(API_DOC_TITLE)
                .description(API_DOC_DESCRIPTION)
                .version(API_DOC_VERSION)
                .license(API_DOC_LICENSE)
                .licenseUrl(API_DOC_LICENSE_URL)
                .build();
    }
}
