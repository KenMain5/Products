package com.atelier.productservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Style {
    @Id
    @NonNull
    private Long styleId;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @NonNull
    private Product product;

    @NonNull
    private String name;


    private Integer salePrice;

    @NonNull
    private Integer originalPrice;


    @NonNull
    private Integer defaultStyle;



}
