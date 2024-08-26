package org.example.capstoneproject.cartline.dto;

import jakarta.persistence.*;
import lombok.*;
import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.product.dto.Product;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class CartLine {
    @Id
    @GeneratedValue
    private int cartLineId;
    private int prodId;
    private int prodPrice;
    private int prodQuantity;
    private int totalPrice;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Product product;
    @ManyToOne
    private Cart cart;
}
