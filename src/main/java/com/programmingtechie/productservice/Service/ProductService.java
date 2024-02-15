package com.programmingtechie.productservice.Service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().build().setName(ProductRequest.getName());
    }
}
