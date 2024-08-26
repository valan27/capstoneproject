package org.example.capstoneproject.cart.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.capstoneproject.cartline.dto.CartLine;
import org.example.capstoneproject.customer.dto.Customer;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue
    private int cartId;
    @OneToOne(mappedBy = "cart")

    @JsonBackReference
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartLine> cartLineProducts;
}
