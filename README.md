1.spring-core.jar
  这个jar 文件包含Spring 框架基本的核心工具类。Spring 其它组件要都要使用到这个包里的类，是其它组件的基本核心，当然你也可以在自己的应用系统中使用这些工具类。
  外部依赖Commons Logging， (Log4J)。
  
  spring-beans.jar
  这个jar 文件是所有应用都要用到的，它包含访问配置文件、创建和管理bean 以及进行Inversion of Control / Dependency Injection（IoC/DI）操作相关的所有类。如果应用只需基本的IoC/DI 支持，引入spring-core.jar 及spring-beans.jar 文件就可以了。
  外部依赖spring-core，(CGLIB)。
  
  spring-aop.jar
  这个jar 文件包含在应用中使用Spring 的AOP 特性时所需的类和源码级元数据支持。使用基于AOP 的Spring特性，如声明型事务管理（Declarative Transaction Management），也要在应用里包含这个jar包。
  外部依赖spring-core， (spring-beans，AOP Alliance， CGLIB，Commons Attributes)。
  
  spring-context.jar
  这个jar 文件为Spring 核心提供了大量扩展。可以找到使用Spring ApplicationContext特性时所需的全部类，JDNI 所需的全部类，instrumentation组件以及校验Validation 方面的相关类。
  外部依赖spring-beans, (spring-aop)。
  
  spring-dao.jar
  这个jar 文件包含Spring DAO、Spring Transaction 进行数据访问的所有类。为了使用声明型事务支持，还需在自己的应用里包含spring-aop.jar。
  外部依赖spring-core，(spring-aop， spring-context， JTA API)。
  
  spring-jdbc.jar
  这个jar 文件包含对Spring 对JDBC 数据访问进行封装的所有类。
  外部依赖spring-beans，spring-dao。
  
  spring-support.jar
  这个jar 文件包含支持UI模版（Velocity，FreeMarker，JasperReports），邮件服务，脚本服务(JRuby)，缓存Cache（EHCache），任务计划Scheduling（uartz）方面的类。
  外部依赖spring-context, (spring-jdbc, Velocity, FreeMarker, JasperReports, BSH, Groovy, JRuby, Quartz, EHCache)
  
  spring-web.jar
  这个jar 文件包含Web 应用开发时，用到Spring 框架时所需的核心类，包括自动载入Web Application Context 特性的类、Struts 与JSF 集成类、文件上传的支持类、Filter 类和大量工具辅助类。
  外部依赖spring-context, Servlet API, (JSP API, JSTL, Commons FileUpload, COS)。
  
  spring-webmvc.jar
  这个jar 文件包含Spring MVC 框架相关的所有类。包括框架的Servlets，Web MVC框架，控制器和视图支持。当然，如果你的应用使用了独立的MVC 框架，则无需这个JAR 文件里的任何类。
  外部依赖spring-web, (spring-support，Tiles，iText，POI)。
  
  spring-portlet.jar
  spring自己实现的一个类似Spring MVC的框架。包括一个MVC框架和控制器。
  外部依赖spring-web， Portlet API，(spring-webmvc)。
  
  spring-struts.jar
  Struts框架支持，可以更方便更容易的集成Struts框架。
  外部依赖spring-web，Struts。
  
  spring-remoting.jar
  这个jar 文件包含支持EJB、远程调用Remoting（RMI、Hessian、Burlap、Http Invoker、JAX-RPC）方面的类。
  外部依赖spring-aop， (spring-context，spring-web，Hessian，Burlap，JAX-RPC，EJB API)。
  
  spring-jmx.jar
  这个jar包提供了对JMX 1.0/1.2的支持类。
  外部依赖spring-beans，spring-aop， JMX API。
  
  spring-jms.jar
  这个jar包提供了对JMS 1.0.2/1.1的支持类。
  外部依赖spring-beans，spring-dao，JMS API。
  
  spring-jca.jar
  对JCA 1.0的支持。
  外部依赖spring-beans，spring-dao， JCA API。
  
  spring-jdo.jar
  对JDO 1.0/2.0的支持。
  外部依赖spring-jdbc， JDO API， (spring-web)。
  
  spring-jpa.jar
  对JPA 1.0的支持。
  外部依赖spring-jdbc， JPA API， (spring-web)。
  
  spring-hibernate2.jar
  对Hibernate 2.1的支持，已经不建议使用。
  外部依赖spring-jdbc，Hibernate2，(spring-web)。
  
  spring-hibernate3.jar
  对Hibernate 3.0/3.1/3.2的支持。
  外部依赖spring-jdbc，Hibernate3，(spring-web)。
  
  spring-toplink.jar
  对TopLink框架的支持。
  外部依赖spring-jdbc，TopLink。
  
  spring-ibatis.jar
  对iBATIS SQL Maps的支持。
  外部依赖spring-jdbc，iBATIS SQL Maps。
  
  另外的两个包。
  
  spring-mock.jar
  这个jar 文件包含Spring 一整套mock 类来辅助应用的测试。Spring 测试套件使用了其中大量mock 类，这样测试就更加简单。模拟HttpServletRequest 和HttpServletResponse 类在Web 应用单元测试是很方便的。并且提供了对JUnit的支持。
  外部依赖spring-core。
  
  spring-aspects.jar
  提供对AspectJ的支持，以便可以方便的将面向方面的功能集成进IDE中，比如Eclipse AJDT。
  外部依赖。
  
  WEAVER JARS (dist/weavers)说明。
  
  spring-agent.jar
  Spring的InstrumentationSavingAgent (为InstrumentationLoadTimeWeaver)，一个设备代理包，可以参考JDK1.5的Instrumentation功能获得更多信息。
  外部依赖none (for use at JVM startup: "-javaagent:spring-agent.jar")。
  
  spring-tomcat-weaver.jar
  扩展Tomcat的ClassLoader，使其可以使用instrumentation（设备）类。
  外部依赖none (for deployment into Tomcat's "server/lib" directory)。
  
2
一、只是使用spring框架
dist\spring.jar
lib\jakarta-commons\commons-logging.jar

如果使用到了切面编程(AOP)，还需要下列jar文件
lib\aspectj\aspectjweaver.jsr 和 aspectjrt.jar
lib\cglib\cglib-nodep-2.1_3.jar

如果使用了JSR-250中的注解如@Resource/@PostConstruct/@PreDestroy
还需下列jar文件
lib\j2ee\common-annotations.jar

二、只是使用spring框架若使用注解方式
只要加一些命名空间和开启解析器
并且@Resource需要加lib\j2ee\common-annotations.jar
<context:annotation-config/>打开处理器

三、要自动扫描
只要开启解析器和一些命名空间
<context:component-scan base-package=""/>

四、spring框架采用aop编程
需要导入一些命名空间
xmlns:aop.......
<aop:aspectj-autoproxy/>开启解析器
如果使用到了切面编程(AOP)，还需要下列jar文件
lib\aspectj\aspectjweaver.jsr 和 aspectjrt.jar
lib\cglib\cglib-nodep-2.1_3.jar

五、spring+Jdbc开发
需要数据源文件 lib\jakarta-commons\commons-pool.jar、lib\jakarta-commons\commons-dbcp.jar
1、spring文件 ：

dist\spring.jar、
 lib\jakarta-commons\commons-logging.jar
2、jdbc驱动文件 mysql**** sql*** ：
导入tx命名空间
<tx:annotation-driven transaction-manager=""/>
对事务注解的解析器


2.转移到logback的理由 
    slf4j支持参数化的logger.error("帐号ID：{}不存在", userId);告别了if(logger.isDebugEnable()) 时代。 
    另外logback的整体性能比log4j也较佳，hibernate等项目已经采用了slf4j:"某些关键操作，比如判定是否记录一条日志语句的操作，其性能得到了显著的提高。
    这个操作在LOGBack中需要3纳秒，而在Log4J中则需要30纳秒。 
    LOGBack创建记录器（logger）的速度也更快：13毫秒，而在Log4J中需要23毫秒。
    更重要的是，它获取已存在的记录器只需94纳秒，而 Log4J需要2234纳秒，时间减少到了1/23。" 