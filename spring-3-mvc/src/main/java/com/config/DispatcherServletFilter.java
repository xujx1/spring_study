package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletFilter extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 第一个方法是getServletMappings()，它会将一个或多个路径映射到DispatcherServlet上。
     * 在本例中，它映射的是“/”，这表示它会是应用的默认Servlet。
     * 它会处理进入应用的所有请求
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }


    /**
     * 借助customizeRegistration()方法中的ServletRegistration.Dynamic，我们能够完成多项任务。
     * 包括通过调用setLoadOnStartup()设置load-on-startup优先级，
     * 通过setInitParameter()设置初始化参数，
     * 通过调用setMultipartConfig()配置Servlet3.0对multipart的支持。、
     * 在前面的样例中，我们设置了对multipart的支持，
     * 将上传文件的临时存储目录设置在“/tmp/user/uploads”中。
     * <p>
     * <p>
     * <p>
     * location = "E:\\upload",//文件存放路径，指定的目录必须存在，否则会抛异常
     * maxFileSize = 8388608,//最大上传文件大小,经测试应该是字节为单位
     * fileSizeThreshold = 819200//当数据量大于该值时，内容将被写入文件。specification中的解释的大概意思，不知道是不是指Buffer size），大小也是已字节单位
     * maxRequestSize =  8*1024*1024*6 //针对该 multipart/form-data 请求的最大数量，默认值为 -1，表示没有限制。以字节为单位。
     */
  /*  @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("D:\\project\\architecture\\spring\\spring-3-mvc\\target\\uploads"));
    }*/

    //注册Filter
  /*  @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new HelloFilter()};
    }*/
}


/*public class DispatcherServletFilter implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        //注册了一个Servlet并将其映射到一个路径上
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("myServlet", MyServlet.class).
                addMapping("/");
        //注册Filter
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("myFilter", MyFilter.class).
                addMappingForServletNames(null, false, "/");
    }
}*/
