package com.nosql.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = "com.nosql")
@PropertySource(value = "classpath:application.properties")
/**
 *借助@EnableMongoRepositories启用Spring Data MongoDB
 *设置repository 目录
 */
@EnableMongoRepositories(basePackages = "com.nosql.repository")
public class Config {

    @Value("${mongodb.url}")
    private String url;

    @Value("${mongodb.post}")
    private Integer post;

    @Value("${mongodb.dbName}")
    private String dbName;

    @Value(("${mongodb.user}"))
    private String user;

    @Value(("${mongodb.password}"))
    private String password;

    @Autowired
    private Mongo mongo;

    /**
     * MongoClien直接创建Mongo实例，
     * 必须要处理MongoClient构造器所抛出的UnknownHostException异常。
     *
     * @Bean public MongoClient mongoClient() {
     * return new MongoClient(url, post);
     * }
     * @Bean public MongoDbFactory mongoDbFactory() {
     * return new SimpleMongoDbFactory(mongoClient(), dbName);
     * }
     */

    /**
     * 注入mongodb实例
     * 使用MongoClientFactoryBean来管理
     *
     * @return mongo
     */

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        //设置数据库用户名密码
     /*   MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(user, dbName, password.toCharArray());*/
        mongo.setHost(url);
        mongo.setPort(post);
       /* mongo.setCredentials(new MongoCredential[]{mongoCredential});*/
        return mongo;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo, dbName);
    }

    /**
     * 我们还可以让配置类扩展AbstractMongoConfiguration
     * 并重载getDatabaseName()和mongo()方法
     */
}
