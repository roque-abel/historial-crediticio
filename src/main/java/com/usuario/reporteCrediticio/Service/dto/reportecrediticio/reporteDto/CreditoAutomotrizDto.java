package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditoAutomotrizDto {
    private Integer totalCuentas;
    private Integer cuentasVigentes;
    private Float lineaTotal;
    private Float saldoTotal;
    private Double usoPorcentaje;
}
