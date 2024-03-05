package com.programmingtechie.productservice.service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductRespose;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getName())
                .price(productRequest.getPrice())
                .build();

            productRepository.save(product);
            log.info("Product {} is saved ", product.getId());
    }
    public List<ProductRespose> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapTopProductResponse).toList();
    }

    private ProductRespose mapTopProductResponse(Product product) {
        return ProductRespose.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
