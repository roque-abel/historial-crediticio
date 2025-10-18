package com.usuario.reporteCrediticio.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentificacionRequest {
    private String rfc;
    private String curp;
    private LocalDate fechaDeNacimiento;
}
