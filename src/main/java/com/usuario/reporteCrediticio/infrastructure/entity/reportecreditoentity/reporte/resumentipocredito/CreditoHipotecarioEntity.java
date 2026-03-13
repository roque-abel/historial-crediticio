package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.resumentipocredito;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditoHipotecarioEntity {
    private Integer totalCuentas;
    private Integer lineaTotal;
    private Double saldoTotal;
}
