package com.liao.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liao.mall.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
public class ProductcontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getProduct_success() throws Exception {

    }

    @Test
    public void getProduct_notfound() throws Exception {
        Product product = new Product();
    }

    @Transactional
    @Test
    public void createProduct_success() throws Exception {
        Product product = new Product();
    }

    @Transactional
    @Test
    public void createProduct_illegalArgument() throws Exception {
        Product product = new Product();
    }

    @Transactional
    @Test

}