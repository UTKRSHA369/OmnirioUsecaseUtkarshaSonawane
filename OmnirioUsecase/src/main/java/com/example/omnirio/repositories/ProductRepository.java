package com.example.omnirio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.omnirio.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
