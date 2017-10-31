package com.example.elasticsearchjavaclientdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.data.elasticsearch")
public class ElasticsearchProperties {

    /**
     * Elasticsearch cluster name.
     */
    private String clusterName = "elasticsearch";

    /**
     * Comma-separated list of cluster node addresses.
     */
    private String clusterNodes;

    private String credentials;

    /**
     * Additional properties used to configure the client.
     */
    private Map<String, String> properties = new HashMap<>();

    public String getClusterName() {
        return this.clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterNodes() {
        return this.clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
