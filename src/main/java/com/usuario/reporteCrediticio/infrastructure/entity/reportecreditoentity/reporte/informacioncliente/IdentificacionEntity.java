package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentificacionEntity {
    private String rfc;
    private String curp;
    private LocalDate fechaNacimiento;
}
