package main.java.ca.gbc.productservice.repositry;

import main.java.ca.gbc.productservice.model.Product;
import org.springframework.data.mongobd.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String>{
    void save(Product product);

    List<Product> findAll();
}
