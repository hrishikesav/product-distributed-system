package com.hrishi.api.service;

import com.hrishi.api.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    @GetMapping(value = "/product/{productId}", produces = "application/json")
    Product getProduct(@PathVariable("productId") int productId);
}
