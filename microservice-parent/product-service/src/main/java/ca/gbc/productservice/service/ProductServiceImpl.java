package main.java.ca.gbc.productservice.service;

import jdk.incubator.concurrent.ScopedValue;
import lombok.RequiredArgsConstructor;
import main.java.ca.gbc.productservice.dto.ProductRequest;
import main.java.ca.gbc.productservice.dto.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import main.java.ca.gbc.productservice.model.Product;
import main.java.ca.gbc.productservice.repositry.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;
    private String id;
    private ScopedValue.Carrier Criteria;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {

        log.debug("Creating a new product {}", productRequest.name());

        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();


        //persist a product
        productRepository.save(product);

        log.info("Product {} is saved", product.getId());

        return new ProductResponse(product.getId(),product.getName(),
                product.getDescription(),product.getPrice());

    }

    @Override
    public List<ProductResponse> getAllProducts() {

        log.debug("Returning a list products");
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product){
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(),product.getPrice());
    }
    @Override
    public String updateProduct(String productId, ProductRequest productRequest) {

        log.debug("Updating a product with id {}", id);

        Query query =new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Product product = mongoTemplete.findOne(query, Product.class);

        if(product != null) {

            product.setDescription(productRequest.description());
            product.setPrice(productRequest.price());
            product.setName(productRequest.name());
            return productRepository.save(product).getId() ;
        }

        return id;
    }

    @Override
    public void deleteProduct(String productId) {

        log.debug("Deleting a product with id {}", id);
        productRepository.deleteById(id);
    }
}
