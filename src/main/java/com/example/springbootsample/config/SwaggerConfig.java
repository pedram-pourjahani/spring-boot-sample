//package com.example.springbootsample.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Collections;
//
//
//@Configuration
//@ConditionalOnExpression(value = "${useSwagger:false}")
//@EnableSwagger2
//public class SwaggerConfig {
//
//    private String appVersion = "";
//
//    private String appName = "Excoino Market Admin - Admin API Service";
//
//    private String appDesc = "Excoino Market Admin - Admin API Service";
//
//    @Bean
//    public Docket createRestApi() {
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder()
//                        .description(appDesc)
//                        .title(appName)
//                        .version(appVersion)
//                        .build())
//
//                .securityContexts(Collections.singletonList(SecurityContext.builder().securityReferences(
//                        Collections.singletonList(new SecurityReference("JWT",
//                                new AuthorizationScope[]{
//                                        new AuthorizationScope("global", "accessEverything")
//                                })
//                        )
//                ).build()))
//                .securitySchemes(Collections.singletonList(new ApiKey("JWT", "Authorization", "header")))
//                .enable(true)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.bizzan.bitrade.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    @Bean
//    UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//                .deepLinking(true)
//                .displayOperationId(false)
//                .defaultModelsExpandDepth(1)
//                .defaultModelExpandDepth(1)
//                .defaultModelRendering(ModelRendering.EXAMPLE)
//                .displayRequestDuration(false)
//                .docExpansion(DocExpansion.NONE)
//                .filter(false)
//                .maxDisplayedTags(null)
//                .operationsSorter(OperationsSorter.ALPHA)
//                .showExtensions(false)
//                .tagsSorter(TagsSorter.ALPHA)
//                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
//                .validatorUrl(null)
//                .build();
//    }
//}