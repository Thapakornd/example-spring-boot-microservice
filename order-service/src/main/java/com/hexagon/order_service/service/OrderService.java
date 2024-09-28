package com.hexagon.order_service.service;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hexagon.order_service.client.ProductClient;
import com.hexagon.order_service.dto.OrderRequest;
import com.hexagon.order_service.dto.OrderResponse;
import com.hexagon.order_service.dto.Product;
import com.hexagon.order_service.model.Order;
import com.hexagon.order_service.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public ResponseEntity<?> placeOrder(OrderRequest orderRequest) {
        Optional<Product> productAvailable = productClient.isInStock(orderRequest.productId());
        if (productAvailable.isPresent()) {
            Order order = new Order(null, orderRequest.username(), productAvailable.get().getId());
            Order orderSaved = orderRepository.save(order);

            OrderResponse orderResponse = new OrderResponse(orderSaved.getId(), orderRequest.username(),
                    productAvailable.get());
            return new ResponseEntity<>(orderResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
