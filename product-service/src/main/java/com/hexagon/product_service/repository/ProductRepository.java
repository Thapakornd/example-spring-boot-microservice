package com.hexagon.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagon.product_service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}