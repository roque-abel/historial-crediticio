package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaRealizadaEntity {
    private LocalDate fecha;
    private String institucion;
    private String tipoConsulta;
    private String motivo;
}
