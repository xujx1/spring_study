package com.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import redis.clients.jedis.JedisPoolConfig;

@Configuration

@PropertySource(value = "classpath:application.properties")
@Import(value = {DataSourceConfig.class, JpaConfig.class})
@ComponentScan(basePackages = "com.cache")
//启用缓存
@EnableCaching
public class Config {

/*    @Autowired
    private CacheManager cacheManager;*/

    /**
     * ConcurrentMapCacheManager缓存管理器使
     * 用java.util.concurrent.ConcurrentHashMap作为其缓存存储
     */
  /*  @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }*/

    /**
     * ehcache直接在jvm虚拟机中缓存，速度快，效率高；
     * 但是缓存共享麻烦，集群分布式应用不方便。
     */
  /*  @Bean
    public CacheManager cacheManager() {
        return new CacheManager();
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        return new EhCacheCacheManager(cacheManager);
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("classpath:ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }*/

    /**
     * 使用redis缓存
     */


    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.timeout}")
    private String timeout;

    @Value("${redis.maxTotal}")
    private String maxTotal;

    @Value("${redis.maxIdle}")
    private String maxIdle;

    @Value("${redis.maxWaitMillis}")
    private String maxWaitMillis;

    @Value("${redis.testOnBorrow}")
    private String testOnBorrow;

    @Value("${redis.database}")
    private String database;


    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Jackson2JsonRedisSerializer jackson2JsonRedisSerializer;


    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
        return jedisPoolConfig;
    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(Integer.parseInt(port));
        jedisConnectionFactory.setTimeout(Integer.parseInt(timeout));
        jedisConnectionFactory.setDatabase(Integer.parseInt(database));
        return jedisConnectionFactory;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        //设置Jackson 序列化方式
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //使用enableDefaultTyping()枚举指定什么样的类型（类）默认输入应该使用
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }

    @Bean
    public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return jackson2JsonRedisSerializer;
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }


    /**
     * spring 配置redis来管理缓存
     * 默认设置5*60分钟
     * 不显示的调redisTemplat的方法
     */
    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(5 * 60);
        return cacheManager;
    }
}
