package com.atelier.productservice.services;

import com.atelier.productservice.model.Style;

import java.util.List;

public interface StyleServices {
    List<Style> getStylesOfProduct(Long product_id);
}
