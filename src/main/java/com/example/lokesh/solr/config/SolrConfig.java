package com.example.lokesh.solr.config;

import org.apache.solr.client.solrj.ResponseParser;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.StreamingBinaryResponseParser;
import org.apache.solr.client.solrj.response.DelegationTokenResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.schema.MappingJacksonResponseParser;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
        basePackages = "com.example.lokesh.solr.repository")
@ComponentScan
public class SolrConfig {

    @Bean
    public SolrClient solrClient() {
        BinaryResponseParser responseParser = new BinaryResponseParser();

        //HttpSolrClient httpSolrClient = new HttpSolrClient("http://localhost:8983/solr",null,responseParser);
        HttpSolrClient httpSolrClient = new HttpSolrClient("http://localhost:8983/solr");
        return httpSolrClient;
        //return new HttpSolrClient("http://localhost:8983/solr");
    }

    @Bean
    public SolrTemplate solrTemplate() throws Exception {
        return new SolrTemplate(solrClient());
    }
}