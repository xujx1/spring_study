package com.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.elasticsearch.repository")
@PropertySource(value = "classpath:application.properties")
@ComponentScan("com.elasticsearch.service")
public class Config {

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${cluster.name}")
    private String clusterName;

    @Bean
    public TransportClient transportClient() {
        TransportClient client = null;
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", clusterName).build();
        try {
            client = TransportClient.
                    builder().
                    settings(settings).
                    build().
                    addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }


    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(transportClient());
    }
}
