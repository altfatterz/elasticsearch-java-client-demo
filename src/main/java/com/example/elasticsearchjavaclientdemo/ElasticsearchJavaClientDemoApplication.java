package com.example.elasticsearchjavaclientdemo;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchJavaClientDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchJavaClientDemoApplication.class, args);
	}

	@Autowired
	TransportClient client;

	@Override
	public void run(String... strings) throws Exception {

		CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate("hello");

		boolean acknowledged = createIndexRequestBuilder.execute().actionGet().isAcknowledged();
		if (acknowledged) {
			System.out.println("index created");
		} else {
			System.out.println("index not created");
		}

	}
}
