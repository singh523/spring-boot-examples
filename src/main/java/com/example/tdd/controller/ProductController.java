package com.example.tdd.controller;

import com.example.tdd.model.Product;
import com.example.tdd.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api1")
@AllArgsConstructor
public class ProductController {

    private ProductService  productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
