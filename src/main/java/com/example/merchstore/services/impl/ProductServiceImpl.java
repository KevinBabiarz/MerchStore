package com.example.merchstore.services.impl;

import com.example.merchstore.exceptions.AlreadyExistException;
import com.example.merchstore.exceptions.InvalidQuantityException;
import com.example.merchstore.exceptions.NotFoundException;
import com.example.merchstore.models.entities.Product;
import com.example.merchstore.repositories.ProductRepository;
import com.example.merchstore.services.notImpl.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long createProduct(Product product) {
        product.setId(null);
        if (productRepository.existsByName(product.getName())) {
            throw new AlreadyExistException(product.getId(),ProductServiceImpl.class.toString());
        }
        product = productRepository.save(product);
        return product.getId();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NotFoundException(productId,ProductServiceImpl.class.toString()));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (product.getQuantity() < 0) {
            throw new InvalidQuantityException(id);
        }
        if (product == null && !productRepository.existsById(id)){
            throw new NotFoundException(id,ProductServiceImpl.class.toString());
        }
        Product tmp = getProductById(id);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long productId) {
        Product product = getProductById(productId);
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll().stream()
                .toList();
    }

    @Override
    public Product updateProductQuantity(Long productId, Long newQuantity) {
        if (newQuantity < 0) {
            throw new InvalidQuantityException(productId);
        }
        Product product = getProductById(productId);
        product.setQuantity(newQuantity);
        return productRepository.save(product);
    }
}
