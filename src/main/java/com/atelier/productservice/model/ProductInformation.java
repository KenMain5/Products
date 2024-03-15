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
public class ProductInformation {
    @Id
    @NonNull
    private Long id;
    @NonNull
    private String category;
    @NonNull
    private String name;
    @NonNull
    private String slogan;
    @NonNull
    private String description;
    @NonNull
    private Integer default_price;


}
