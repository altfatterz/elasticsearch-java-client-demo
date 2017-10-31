package com.example.elasticsearchjavaclientdemo;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticsearchConfiguration {

    private final ElasticsearchProperties properties;

    public ElasticsearchConfiguration(ElasticsearchProperties properties) {
        this.properties = properties;
    }

    @Bean
    public TransportClient elasticsearchClient() throws Exception {
        TransportClientFactoryBean factory = new TransportClientFactoryBean();
        factory.setClusterNodes(this.properties.getClusterNodes());
        factory.setProperties(createProperties());
        factory.afterPropertiesSet();
        TransportClient client = factory.getObject();
        return client;
    }

    private Properties createProperties() {
        Properties properties = new Properties();
        properties.put("cluster.name", this.properties.getClusterName());
        properties.putAll(this.properties.getProperties());
        return properties;
    }

}
