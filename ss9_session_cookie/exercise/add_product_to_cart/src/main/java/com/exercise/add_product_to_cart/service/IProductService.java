package com.exercise.add_product_to_cart.service;

import com.exercise.add_product_to_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);
}
