package config;

import aop.Audience;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.impl.PerformanceImpl;

@Configuration
@ComponentScan(basePackageClasses = {PerformanceImpl.class, Audience.class})
//启动AspectJ自动代理
@EnableAspectJAutoProxy
public class Config {

}
