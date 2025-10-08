package com.usuario.prosesor.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {

    private Integer clienteId;
    private String nombre;
    private String apelldios;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;
    private String estado;
    private String rfc;
    private String curp;
    private LocalDate fechaNacimiento;

}
