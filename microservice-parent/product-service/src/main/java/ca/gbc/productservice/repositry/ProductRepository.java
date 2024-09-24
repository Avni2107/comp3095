package main.java.ca.gbc.productservice.repositry;

import main.java.ca.gbc.productservice.model.Product;
import org.springframework.data.mongobd.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{
}
