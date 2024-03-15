package com.atelier.productservice.services.implementation;

import com.atelier.productservice.model.Product;
import com.atelier.productservice.repository.ProductRepository;
import com.atelier.productservice.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImpl implements ProductServices {
    private ProductRepository productRepository;

    @Autowired
    public ProductServicesImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        Pageable pageable = PageRequest.of(1, 5);
        Page<Product> page = productRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public Product getSpecificProduct(Long product_id) {
        Optional<Product> optionalProduct = productRepository.getProductById(product_id);
        return optionalProduct.orElseThrow(() -> new IllegalArgumentException("Argument given is out of bounds"));
    }
}
