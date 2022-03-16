package com.product.crud.controller;


import com.product.crud.model.Product;
import com.product.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> fetchProducts() {
        return productService.fetchProducts();
    }

    @PostMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product fetchProductById(@PathVariable int id) {
        return productService.fetchProductById(id);
    }

    @PutMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product editProductById(@PathVariable int id, @RequestBody Product product) {
        return  productService.editProductById(id, product);
    }

    @DeleteMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);
    }
}
