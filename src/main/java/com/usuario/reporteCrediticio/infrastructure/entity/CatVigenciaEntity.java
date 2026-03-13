package com.usuario.reporteCrediticio.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cat-viencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatVigenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String producto;
    @Column(name = "dias-vigencia")
    private Integer diasVigencia;
}
