package com.usuario.reporteCrediticio.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cat-viencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatVigenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String producto;
    @Column(name = "dias-vigencia")
    private Integer diasVigencia;
}
