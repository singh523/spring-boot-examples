package com.example.tdd.controller;

import com.example.tdd.model.Product;
import com.example.tdd.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    public void testFindAllProducts() throws Exception {

        String productJson = """
                [
                    {
                        "id": 1,
                        "name": "Product1",
                        "description": "Product1 description",
                        "price": 100.00
                    }
                ]
                """;
        when(productService.getProducts()).thenReturn(List.of(new Product(1, "Product1", "Product1 description", 100.00)));
        mockMvc.perform(get("/api1/getProducts")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(productJson));
    }
}
