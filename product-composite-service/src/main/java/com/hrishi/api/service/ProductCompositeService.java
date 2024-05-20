package com.hrishi.api.service;

import com.hrishi.api.model.ProductAggregate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductCompositeService {

    @GetMapping(
            value    = "/product-composite/{productId}",
            produces = "application/json")
    ProductAggregate getProduct(@PathVariable("productId") int productId);
}
