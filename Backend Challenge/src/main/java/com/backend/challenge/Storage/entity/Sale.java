package com.backend.challenge.Storage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name="Sales")
public class Sale {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="creationDate")
    private Date creationDate;
    @Column(name="clientId")
    private Long clientId;
    @Column(name="productId")
    private Long productId;
    @Column(name="quantity")
    private int quantity;
    @Column(name="price")
    private double price;
}
