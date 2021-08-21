package com.example.omnirio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.omnirio.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
