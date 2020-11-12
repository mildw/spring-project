package com.mildw.minsu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {
        "classpath:properties/security.properties",
        "file:${TOMCAT_PROP_DIR}/security.properties"
}, ignoreResourceNotFound = true)
public class PropertySourceConfig {
}
