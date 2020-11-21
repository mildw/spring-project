package com.mildw.minsu.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

public class servletConfig implements WebMvcConfigurer {

    public static final int STATIC_RESOURCE_CACHE_PERIOD = 60;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/", "classpath:/static/", "classpath:/static/resources/")
                .setCachePeriod(STATIC_RESOURCE_CACHE_PERIOD)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new PathResourceResolver())
                ;

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(STATIC_RESOURCE_CACHE_PERIOD)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new PathResourceResolver())
        ;
    }
}
