package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto;

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
    private Float lineaCreditoTotal;
    private Float saldoTotalActual;
    private Float pagoMensualTotal;
    private Double porcentajeEndeudamiento;
}
