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
public class Feature {
    @Id
    @NonNull
    private Long featureId;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private ProductInformation productInformation;

    @NonNull
    private String feature;

    @NonNull
    private String value;

}
