package com.hrishi.api.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {

    public String getServiceAddress() {
        return "1.0.0.1";
    }
}
