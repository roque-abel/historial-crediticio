package com.usuario.reporteCrediticio.infrastructure.entity.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumenGeneralEntity {
    private Integer totalCreditos;
    private Integer creditosVigentes;
    private Integer creditosCerrados;
    private Integer creditosEnMora;
    private Float lineaCreditoTotal;
    private Float saldoTotalActual;
    private Float pagoMensualTotal;
    private Double porcentajeEndeudamiento;
}
