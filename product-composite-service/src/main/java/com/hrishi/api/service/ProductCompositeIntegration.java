package com.hrishi.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrishi.api.model.Product;
import com.hrishi.api.model.Recommendation;
import com.hrishi.api.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
public class ProductCompositeIntegration implements ProductService, RecommendationService, ReviewService{

    RestTemplate restTemplate;
    ObjectMapper mapper;

    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    int productServicePort = 7001;
    int recommendationServicePort = 7002;
    int reviewServicePort = 7003;

    public ProductCompositeIntegration(RestTemplate restTemplate,
                                       ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        productServiceUrl = "http://localhost:7001/product/";
        recommendationServiceUrl = "http://localhost:7002/recommendation?productId=";
        reviewServiceUrl = "http://localhost:7003/review?productId=";
    }

    @Override
    public Product getProduct(int productId) {
        try {
            String url = productServiceUrl + productId;

            return restTemplate.getForObject(url, Product.class);

        } catch (HttpClientErrorException ex) {
            throw ex;
        }
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        try {
            String url = recommendationServiceUrl + productId;

            List<Recommendation> recommendations = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Recommendation>>() {}).getBody();

            return recommendations;

        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Review> getReviews(int productId) {
        try {
            String url = reviewServiceUrl + productId;

            List<Review> reviews = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Review>>() {}).getBody();

            return reviews;

        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

}
