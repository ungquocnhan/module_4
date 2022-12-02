package com.exercise.add_product_to_cart.repository;

import com.exercise.add_product_to_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
