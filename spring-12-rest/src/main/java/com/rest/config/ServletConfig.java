package com.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
@EnableWebMvc
//设置扫描路径
@ComponentScan("com.rest.controller")
class ServletConfig extends WebMvcConfigurerAdapter {

    /**
     * 1．确定请求的媒体类型；
     * 2．找到适合请求媒体类型的最佳视图。
     */
    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager configurer) {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(configurer);
        return viewResolver;
    }

    /**
     * 以bean的形式查找视图
     */
  /*  @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }*/
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_PLAIN);
    }
}
