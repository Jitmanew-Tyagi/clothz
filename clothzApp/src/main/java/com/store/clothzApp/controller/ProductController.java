package com.store.clothzApp.controller;

import com.store.clothzApp.dto.requests.ProductRequest;
import com.store.clothzApp.dto.responses.ProductResponse;
import com.store.clothzApp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @GetMapping("/demo")
    public String demo() {
        return "Works !!";
    }

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest productRequest) {
        log.info("[Controller addProduct] Save request received for {}", productRequest.getName());
        return productService.saveProduct(productRequest);
    }

    @GetMapping("/all")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
