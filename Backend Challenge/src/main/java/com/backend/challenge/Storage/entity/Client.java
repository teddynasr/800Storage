package com.backend.challenge.Storage.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Clients")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="mobile")
    private String mobile;
}
