package com.backend.challenge.Storage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name="Products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable=false)
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="category", nullable=false)
    private String category;
    @Column(name="creationDate")
    private Date creationDate;
}
