package com.github.hth.curlperformance.service;

import com.github.hth.curlperformance.dto.SolrResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ElasticPerformanceService {
    private static final Logger log = LoggerFactory.getLogger(ElasticPerformanceService.class);

    private final RestClient restClientSolr;
    private final RestClient restClientElastic;

    @Autowired
    public ElasticPerformanceService(
            @Value("${url.solr}")
            String solrUrl,

            @Value("${url.elastic}")
            String elasticUrl
    ) {
        log.info("URL {} {}", solrUrl, elasticUrl);
        this.restClientSolr = RestClient.builder()
                .baseUrl(solrUrl)
                .build();

        this.restClientElastic = RestClient.builder()
                .baseUrl(elasticUrl)
                .build();
    }

    public List<SolrResponse> findAll() {
        return restClientSolr.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<SolrResponse>>() {});
    }

}
