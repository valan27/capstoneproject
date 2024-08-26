package org.example.capstoneproject.product.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue
    private int prodId;
    private String prodName;
    private int prodPrice;
    private double prodRating;
    private String prodCategory;
    private String prodSeller;
    private int prodQuantity;

}
