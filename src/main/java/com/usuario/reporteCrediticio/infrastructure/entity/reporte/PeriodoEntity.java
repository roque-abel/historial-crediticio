package com.usuario.reporteCrediticio.infrastructure.entity.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodoEntity {
    private String mes;
    private String estatus;
}
