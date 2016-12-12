package com.jpa.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
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

    /**
     * logback 监听器
     */
  /*  @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);

        super.onStartup(servletContext);
    }
*/
    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {

        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
        super.registerDispatcherServlet(servletContext);
    }


    /**
     * 注册过滤器，映射路径与DispatcherServlet一致，路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        return new Filter[]{characterEncodingFilter};
    }
}
