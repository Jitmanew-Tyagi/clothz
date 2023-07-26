package com.store.clothzApp.service.impl;
import com.store.clothzApp.dto.requests.ProductRequest;
import com.store.clothzApp.dto.responses.ProductResponse;
import com.store.clothzApp.model.Product;
import com.store.clothzApp.repository.ProductRepository;
import com.store.clothzApp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<String> saveProduct(ProductRequest productRequest) {
        log.info("[Service saveProduct] Save request received for {}", productRequest.getName());
        ResponseEntity<String> response;
        try {
            Product product = Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .build();
            Product isSaved = productRepository.save(product);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e) {
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> allProds = productRepository.findAll();
        Stream<ProductResponse> prods = allProds.stream().map(this::mapToProductResponse);
        return prods.collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
