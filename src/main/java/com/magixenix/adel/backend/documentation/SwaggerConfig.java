package com.magixenix.adel.backend.documentation;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("api.adels.xyz")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.magixenix.adel"))
                .build()
                .apiInfo(metaData());
    }

    private Predicate<String> regex(String s) {
        return new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return false;
            }
        };
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Adel REST API")
                .description("\"Adel REST API.\"")
                .version("1.0.0")
                .license("Adel Version 1.0")
                .contact(new Contact("Adel", "https://adels.xyz", "yibrahim.py@gmail.com"))
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:media/images/");
    }
}
