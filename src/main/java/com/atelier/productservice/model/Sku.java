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
public class Sku {
    @Id
    @NonNull
    private Long skuId;

    @ManyToOne
    @JoinColumn(name = "style_id")
    @NonNull
    private Style style;

    @NonNull
    private String size;

    @NonNull
    private Integer quantity;






}
