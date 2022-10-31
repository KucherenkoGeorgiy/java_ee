package com.hillel.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RecordsOfOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Product product;
    private int quantityOfProduct;

    public RecordsOfOrder(Product product, int quantityOfProduct) {
        this.product = product;
        this.quantityOfProduct = quantityOfProduct;
    }
}
