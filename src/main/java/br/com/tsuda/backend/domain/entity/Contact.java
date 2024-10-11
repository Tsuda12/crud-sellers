package br.com.tsuda.backend.domain.entity;

import br.com.tsuda.backend.domain.enums.ContactTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private ContactTypeEnum type;
    private String value;
}
