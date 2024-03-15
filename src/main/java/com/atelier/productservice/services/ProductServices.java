package com.atelier.productservice.services;

import com.atelier.productservice.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServices {
    List<Product> getProducts();
    Product getSpecificProduct(Long product_id);
}
