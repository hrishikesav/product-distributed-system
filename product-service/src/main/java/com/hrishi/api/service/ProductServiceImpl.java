package com.hrishi.api.service;

import com.hrishi.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService{
    @Autowired
    ServiceUtil serviceUtil;
    @Override
    public Product getProduct(int productId) {
        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }
}
