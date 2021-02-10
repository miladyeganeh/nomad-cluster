package com.nomadsample.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages
        = "com.nomadsample.repositories")
@ComponentScan(basePackages = { "com.nomadsample" })
public class ElasticsearchClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${es.node.name}")
    private String node;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        System.out.println("#######Elastic node: " + node);
        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo(node)
                        .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
