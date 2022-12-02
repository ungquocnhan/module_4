package com.exercise.add_product_to_cart.service.impl;

import com.exercise.add_product_to_cart.model.Product;
import com.exercise.add_product_to_cart.repository.IProductRepository;
import com.exercise.add_product_to_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
}
