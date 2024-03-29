package com.atelier.productservice.repository;

import com.atelier.productservice.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    List<Style> findAllByProductId(Long productId);

}
