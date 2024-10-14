package br.com.tsuda.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lineAddress;
    private String number;
    private String postalCode;
    private String neighborhood;
    private String city;
    private String state;
    private String complement;
}
