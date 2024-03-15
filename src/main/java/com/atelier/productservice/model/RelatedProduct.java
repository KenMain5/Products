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
public class RelatedProduct {
    @Id
    @NonNull
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NonNull
    private ProductInformation productInformation;

    @NonNull
    private Integer relatedProductId;



}
