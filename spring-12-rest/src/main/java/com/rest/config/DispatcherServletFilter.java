package com.rest.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;

@Configuration
public class DispatcherServletFilter extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {

        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
        super.registerDispatcherServlet(servletContext);
    }

}
