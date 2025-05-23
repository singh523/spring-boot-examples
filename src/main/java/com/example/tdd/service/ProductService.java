package com.example.tdd.service;

import com.example.tdd.model.Product;
import org.springframework.stereotype.Service;
import com.example.tdd.utils.TestUtils;

import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts() {
        return TestUtils.mockProducts();
    }


}
