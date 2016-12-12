Spring Security是一种基于Spring AOP和Servlet规范中的Filter实现的安全框架。

            9.1　 Spring Security被分成了11个模块
模　　块                    描　　述
ACL                         支持通过访问控制列表（access control list，ACL）为域对象提供安全性
切面（Aspects）             一个很小的模块，当使用Spring Security注解时，会使用基于AspectJ的切面，而不是使用标准的Spring AOP
CAS客户端（CASClient）      提供与Jasig的中心认证服务（Central Authentication Service，CAS）进行集成的功能
配置（Configuration）       包含通过XML和Java配置Spring Security的功能支持
核心（Core）                提供Spring Security基本库
加密（Cryptography）        提供了加密和密码编码的功能
LDAP                        支持基于LDAP进行认证
OpenID                      支持使用OpenID进行集中式认证
Remoting                    提供了对Spring Remoting的支持
标签库（Tag Library）       Spring Security的JSP标签库
Web                         提供了Spring Security基于Filter的Web安全性支持


        　重载WebSecurityConfigurerAdapter的configure()方法
方　　法                                                    描　　述
configure(WebSecurity)                                      通过重载，配置Spring Security的Filter链
configure(HttpSecurity)                                     通过重载，配置如何通过拦截器保护请求
configure(AuthenticationManagerBuilder)                     通过重载，配置user-detail服务


从Spring Security 3.2开始，默认就会启用CSRF防护
Spring Security通过一个同步token的方式来实现CSRF防护的功能