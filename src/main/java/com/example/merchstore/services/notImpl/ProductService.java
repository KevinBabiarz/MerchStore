package com.example.merchstore.services.notImpl;

import com.example.merchstore.models.entities.Product;

import java.util.List;

public interface ProductService {

    public Long createProduct(Product product);
    public Product getProductById(Long productId);
    public Product updateProduct(Long id, Product product);
    public Product deleteProduct(Long productId);
    public List<Product> getAllProducts();
    public Product updateProductQuantity(Long productId, Long newQuantity);


}
