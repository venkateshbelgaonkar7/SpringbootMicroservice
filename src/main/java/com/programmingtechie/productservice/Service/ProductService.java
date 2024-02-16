package com.programmingtechie.productservice.Service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductRespose;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductRespose> getAllProducts() {

        List<Product> products = productRepository.findAll();
        products.stream().map(product -> mapToProductRespose());
    }

    private ProductRespose mapToProductRespose(Product product) {
        return ProductRespose.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
