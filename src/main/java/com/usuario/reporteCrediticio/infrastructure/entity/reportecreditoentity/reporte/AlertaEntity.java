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
public class AlertaEntity {
    private String tipo;
    private String descripcion;
    private String nivel;
    private LocalDate fechaGeneracion;
}
