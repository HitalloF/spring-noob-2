package br.com.bloco.entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "bloco")
@Table(name = "bloco")
@Data
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

}
