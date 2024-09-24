package main.java.ca.gbc.productservice.service;

import main.java.ca.gbc.productservice.dto.ProductRequest;
import main.java.ca.gbc.productservice.dto.ProductResponse;
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    string updateProduct(String productId, ProductRequest productRequest);
    void deleteProduct(String productId);
}
