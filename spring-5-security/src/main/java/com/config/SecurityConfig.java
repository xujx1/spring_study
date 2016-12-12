package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
//启用web安全性注解
@EnableWebSecurity
/**
 * 通过重载WebSecurityConfigurerAdapter
 * 三个configure()方法来配置Web安全性
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Value("${USER_BY_USERNAME_QUERY}")
    private String USER_BY_USERNAME_QUERY;


    @Value("${AUTHORITIES_BY_USERNAME_QUERY}")
    private String AUTHORITIES_BY_USERNAME_QUERY;

    /**
     * 通过重载，配置user-detail服务
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加两个用户
        /*auth.inMemoryAuthentication().
                withUser("user").password("password").roles("USER").and().
                withUser("admin").password("password").roles("ADMIN", "USER");*/
        //JdbcDaoImpl 类里面写死了默认查找用户信息所执行的sql
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery(USER_BY_USERNAME_QUERY).
                authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY)/*.
                passwordEncoder(new StandardPasswordEncoder("test"))*/;
    }

    /**
     * 通过重载，配置如何通过拦截器保护请求
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  禁用Spring Security的CSRF防护功能
        http.csrf().disable();*/
        /*启动默认登陆页面*/
        http.formLogin().and().
                authorizeRequests().
                //指定了对“/user/me”路径的请求需要进行认证
                        antMatchers("/user/me").hasAnyAuthority("USER", "ADMIN").
                //说明对“/user”路径的HTTP GET请求必须要经过认证
                        antMatchers(HttpMethod.GET, "/user/list").hasAnyAuthority("ADMIN").
                            /*  antMatchers("/user/list").access("hasRole('ADMIN') and hasIPAddress('127.0.0.1')").*/
                //说明其他所有的请求都是允许的， 不需要认证和任何的权限
                        anyRequest().permitAll();
    }

    /**
     * 通过重载，配置Spring Security的Filter链
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
