package com.cache.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
class DataSourceConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maxActive}")
    private int maxActive;

    @Value("${jdbc.initialSize}")
    private int initialSize;

    @Value("${jdbc.minIdle}")
    private int minIdle;


    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(driver);
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);

        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);

        // 连接等待超时的时间,单位毫秒
        datasource.setMaxWait(180000);

        // 连接在池中最小生存的时间,单位是毫秒
        // 由于线上配置的时间只有60秒,如果池中的生存时间大于该值,而且有没有被检测回收,再次连接抛出discard connection
        datasource.setMinEvictableIdleTimeMillis(60000);

        // 空闲连接回收器线程运行期间休眠的时间值,单位毫秒
        // 每隔多长时间检测池中的连接是否alive,
        // 该值一般比minEvictableIdleTimeMillis小,否则可能整个线程声明周期都不会被检测到
        datasource.setTimeBetweenEvictionRunsMillis(30000);

        datasource.setValidationQuery("SELECT 'x'");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);

        datasource.setPoolPreparedStatements(false);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(20);

        // 启用WEB监控,filter名称
        datasource.setFilters("wall,stat");

        // 关闭长时间不使用的连接超时时间,单位秒
        datasource.setRemoveAbandoned(false);
        datasource.setRemoveAbandonedTimeout(180);
        // 将当前关闭动作记录到日志
        datasource.setLogAbandoned(true);

        return datasource;
    }
}
