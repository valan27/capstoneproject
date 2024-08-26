package org.example.capstoneproject.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.capstoneproject.cart.dto.Cart;
import org.example.capstoneproject.order.dto.Order;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue
    private int cusId;
    private String cusName;
    private String cusCity;
    private int cusPinCode;
    private String cusGender;
    private String cusEmail;
    private String cusPhone;
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonManagedReference
    @JsonIgnore
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "orId")
//    @JsonManagedReference
    @JsonIgnore
    private Order orderTab;


}
