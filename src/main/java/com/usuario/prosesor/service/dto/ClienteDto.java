package com.usuario.prosesor.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private Integer clienteId;
    private String nombre;
    private String apellidos;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;
    private String estado;
    private String rfc;
    private String curp;
    private LocalDate fechaNacimiento;
}
