package main.java.ca.gbc.productservice.service;

import main.java.ca.gbc.productservice.dto.ProductRequest;
import main.java.ca.gbc.productservice.dto.ProductResponse;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return null;
    }

    @Override
    public string updateProduct(String productId, ProductRequest productRequest) {
        return null;
    }

    @Override
    public void deleteProduct(String productId) {

    }
}
