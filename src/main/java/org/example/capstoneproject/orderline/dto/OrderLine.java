package org.example.capstoneproject.orderline.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.example.capstoneproject.order.dto.Order;
import org.example.capstoneproject.product.dto.Product;

import java.time.LocalDate;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderLine {
    @Id
    @GeneratedValue
    private int orLineId;
    private int orLinePrice;
    private int orLineTotPrice;
    private LocalDate orLineDate;
    private String orLineStatus;
    private int orLineProdQuantity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;
}
