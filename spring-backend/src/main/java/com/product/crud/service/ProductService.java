package com.product.crud.service;

import com.product.crud.model.Product;
import com.product.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product fetchProductById(int id) {
        return productRepository.findById(id).get();
    }

    public String deleteProductById(int id) {
        productRepository.deleteById(id);
        return "Product with id " + id + " deleted successfully";
    }

    public Product editProductById(int id, Product product) {
        Product productDB = productRepository.getById(id);
        if(Objects.nonNull(product.getName()) && !"".equals(product.getName())) {
            productDB.setName(product.getName());
        }

        if(Objects.nonNull(product.getDesc()) && !"".equals(product.getDesc())) {
            productDB.setDesc(product.getDesc());
        }

        if(Objects.nonNull(product.getPrice()) && product.getPrice() != 0) {
            productDB.setPrice(product.getPrice());
        }
        
        return productRepository.save(productDB);
    }
}
