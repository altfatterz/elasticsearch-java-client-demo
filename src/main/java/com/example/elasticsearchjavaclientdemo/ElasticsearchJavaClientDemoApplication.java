package com.example.elasticsearchjavaclientdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * remove index:
 * http delete :9200/<index-name>
 *
 * view indices:
 * http :9200/_cat/indices
 *
 *
 */
@SpringBootApplication
public class ElasticsearchJavaClientDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchJavaClientDemoApplication.class, args);
	}

	@Autowired
	TransportClient client;

	@Override
	public void run(String... strings) throws Exception {

		String indexName = "demo-index";
		String indexType = "demo-type";
		String id = UUID.randomUUID().toString();
//
//		CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate(indexName);
//
//		boolean acknowledged = createIndexRequestBuilder.execute().actionGet().isAcknowledged();
//		if (acknowledged) {
//			System.out.println("index created");
//		} else {
//			System.out.println("index not created");
//		}

		// do not ask ES to generate an id.
		IndexRequestBuilder indexRequestBuilder = client.prepareIndex(indexName, indexType, id);

		ObjectMapper objectMapper = new ObjectMapper();
		Position position = new Position(id, UUID.randomUUID().toString());
		objectMapper.writeValueAsString(position);

		indexRequestBuilder.setSource(objectMapper.writeValueAsString(position), XContentType.JSON);

		String documentId = indexRequestBuilder.execute().actionGet().getId();

		System.out.println(documentId);


	}
}
