package com.atelier.productservice.services.implementation;

import com.atelier.productservice.model.Style;
import com.atelier.productservice.repository.StyleRepository;
import com.atelier.productservice.services.StyleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StyleServicesImpl implements StyleServices {

    private StyleRepository styleRepository;

    @Autowired
    public StyleServicesImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }


    @Override
    public List<Style> getStylesOfProduct(Long product_id) {
        List<Style> list = styleRepository.findAllByProductId(product_id);
        return list;
    }
}
