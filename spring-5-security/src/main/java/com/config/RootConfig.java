package com.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource({"classpath:application.properties"})
@ComponentScan(
        basePackages = "com",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@Import(value = {DataSourceConfiguration.class})
class RootConfig {

}
