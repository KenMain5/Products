package com.atelier.productservice.services;

import java.util.List;

public interface RelatedServices {
    List<Long> getRelatedProductIDs(Long productID);
}
