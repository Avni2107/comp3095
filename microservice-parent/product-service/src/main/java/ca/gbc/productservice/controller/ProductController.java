package main.java.ca.gbc.productservice.controller;


import main.java.ca.gbc.productservice.dto.ProductRequest;
import main.java.ca.gbc.productservice.dto.ProductResponse;
import main.java.ca.gbc.productservice.service.ProductService;
import main.java.ca.gbc.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.net.http.HttpHeaders;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpsStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }


    @GetMapping
    @ResposeStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    //http://localhost:8080/api/product/jlgkdfhjghdfkjghdfkj
    public ResponseEntity<?> update(@PathVariable("productId") String productId, @RequestBody ProductRequest productRequest) {
        // Your method implementation here
    }

    {

        String updatedProductId = productService.updateProduct(productId, productRequest);

        //set the locatin header attribute
        HttpHeaders header = new HttpHeaders();
        headers.add("Location", "/api/product/" + updatedProduct);


        return new ReponseEntity<>(header, HttpStatus.NO_CONTENT);
    };

    @DeleteMapping
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId){

        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}