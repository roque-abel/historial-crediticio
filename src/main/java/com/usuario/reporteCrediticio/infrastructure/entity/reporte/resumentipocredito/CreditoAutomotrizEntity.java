package com.usuario.reporteCrediticio.infrastructure.entity.reporte.resumentipocredito;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditoAutomotrizEntity {
    private Integer totalCuentas;
    private Integer cuentasVigentes;
    private Float lineaTotal;
    private Float saldoTotal;
    private Double usoPorcentaje;
}
