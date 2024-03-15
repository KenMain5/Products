package com.atelier.productservice.repository;

import com.atelier.productservice.model.RelatedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelatedProductRepository extends JpaRepository<RelatedProduct, Long> {
    @Query("SELECT rp.relatedProductId FROM RelatedProduct rp WHERE rp.productInformation.id = :productId")
    List<Long> findRelatedProductIdsByProductInformationId(@Param("productId") Long productId);

}
