package com.atelier.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Product {
    @Id
    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String slogan;

    @NonNull
    private String description;

    @NonNull
    private String category;

    @NonNull
    private Integer default_price;


}
