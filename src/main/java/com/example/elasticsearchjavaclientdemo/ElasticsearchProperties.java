package com.example.elasticsearchjavaclientdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.data.elasticsearch")
@Data
public class ElasticsearchProperties {

    /**
     * Elasticsearch cluster name.
     */
    private String clusterName = "elasticsearch";

    /**
     * Comma-separated list of cluster node addresses.
     */
    private String clusterNodes;

    /**
     * Additional properties used to configure the client.
     */
    private Map<String, String> properties = new HashMap<>();

}
