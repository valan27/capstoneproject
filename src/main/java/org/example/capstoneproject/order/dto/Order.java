package org.example.capstoneproject.order.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.example.capstoneproject.customer.dto.Customer;
import org.example.capstoneproject.orderline.dto.OrderLine;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ordertab")
public class Order {
    @Id
    @GeneratedValue
    private int orId;
    private int orTotPrice;

    @ManyToOne
    @JoinColumn(name = "cusId")
    @JsonIgnore
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "linetab")
    private List<OrderLine> orLineList;
}
