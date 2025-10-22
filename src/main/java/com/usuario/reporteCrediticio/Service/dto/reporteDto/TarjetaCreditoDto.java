package com.usuario.reporteCrediticio.Service.dto.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarjetaCreditoDto {
    private Integer totalCuentas;
    private Integer cuentasVigentes;
    private Integer cuentasCerradas;
    private Integer cuentasEnMora;
    private Float lineaTotal;
    private Float saldoTotal;
    private Double usoPorcentaje;
}
