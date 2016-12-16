package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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

/**
 * 启用基于注解的方法安全性  @Secured
 * @EnableGlobalMethodSecurity(securedEnabled = true)
 */
/**
 *当使用其他框架或API来处理注解的话，使用标准的@RolesAllowed注解会更有意义
 *@EnableGlobalMethodSecurity(jsr250Enabled = true)
 */

/**
 * 启用@PreAuthorize和@PostAuthorize注解限制对方法的调用
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(value = DataSourceConfiguration.class)
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
                withUser("user").password("password").roles("ROLE_USER").and().
                withUser("admin").password("password").roles("ROLE_ADMIN", "ROLE_USER");*/
        //JdbcDaoImpl 类里面写死了默认查找用户信息所执行的sql
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery(USER_BY_USERNAME_QUERY).
                authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY)/*.
                passwordEncoder(new StandardPasswordEncoder("test"))*/;
        System.out.println(auth.inMemoryAuthentication().getUserDetailsService().toString());
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
                        antMatchers("/user/").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_ROOT").
                //说明对“/user”路径的HTTP GET请求必须要经过认证
                        antMatchers(HttpMethod.GET, "/user/list").hasAnyAuthority("ROLE_ADMIN", "ROLE_ROOT").
                            /*  antMatchers("/user/list").access("hasRole('ADMIN') and hasIPAddress('127.0.0.1')").*/
                /**
                 * 配置add方法的拦截允许的权限，
                 * 或者使用   @Secured(value = "ROOT") 拦截Add方法
                 */
                       /* antMatchers(HttpMethod.GET, "/user/add").hasAnyAuthority("ROLE_ROOT").*/
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
