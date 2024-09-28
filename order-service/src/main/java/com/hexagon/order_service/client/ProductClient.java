package com.hexagon.order_service.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hexagon.order_service.dto.Product;

@FeignClient(value = "product", url = "http://localhost:8080")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    Optional<Product> isInStock(@PathVariable int id);
}
