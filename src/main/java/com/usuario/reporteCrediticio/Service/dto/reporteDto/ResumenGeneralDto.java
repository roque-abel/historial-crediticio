package com.usuario.reporteCrediticio.Service.dto.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumenGeneralDto {
    private Integer totalCreditos;
    private Integer creditosVigentes;
    private Integer creditosCerrados;
    private Integer creditosEnMora;
    private float lineaCreditoTotal;
    private float saldoTotalActual;
    private float pagoMensualTotal;
    private double porcentajeEndeudamiento;
}
