package com.atelier.productservice.services.implementation;

import com.atelier.productservice.repository.RelatedProductRepository;
import com.atelier.productservice.services.RelatedServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatedServicesImpl implements RelatedServices {
    private RelatedProductRepository relatedProductRepository;
    private Logger logger = LoggerFactory.getLogger(RelatedServicesImpl.class);

    @Autowired
    public RelatedServicesImpl(RelatedProductRepository relatedProductRepository) {
        this.relatedProductRepository = relatedProductRepository;
    }

    @Override
    public List<Long> getRelatedProductIDs(Long product_id) {

        try {
            List<Long> relatedProductsIds = relatedProductRepository.findRelatedProductIdsByProductInformationId(product_id);
            return relatedProductsIds;
        } catch (Exception e) {
            logger.error("there was an error", e);
            return null;

        }

        //return relatedProductIds.orElseThrow(() -> new IllegalArgumentException("Argument given is out of bounds"));
    }
}
