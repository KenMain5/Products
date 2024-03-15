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
public class Photo {
    @Id
    @NonNull
    private Long photosId;

    @ManyToOne
    @JoinColumn(name = "style_id")
    @NonNull
    private Style style;

    @NonNull
    private String url;

    @NonNull
    private String thumbnailUrl;


}
