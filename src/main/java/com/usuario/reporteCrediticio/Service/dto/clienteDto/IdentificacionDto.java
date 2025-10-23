package com.usuario.reporteCrediticio.Service.dto.clienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentificacionDto {
    private String rfc;
    private String curp;
    private LocalDate fechaNacimiento;
}
