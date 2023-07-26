package com.store.clothzApp.service;

import com.store.clothzApp.dto.requests.ProductRequest;
import com.store.clothzApp.dto.responses.ProductResponse;
import com.store.clothzApp.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public ResponseEntity<String> saveProduct(ProductRequest productRequest);
    public List<ProductResponse> getAllProducts();
}
