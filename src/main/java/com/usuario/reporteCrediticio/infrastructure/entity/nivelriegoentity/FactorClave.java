package com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FactorClave {
    @Column(name = "uso_credito")
    private String usoCredito;
    @Column(name = "historial_pagos")
    private String historialPagos;
    @Column(name = "ingresos_estimados")
    private Integer ingresosEstimados;
    @Column(name = "deuda_total")
    private Integer deudaTotal;
    @Column(name = "porcentaje_deuda_sobre_ingreso")
    private Double porcentajeDeudaSobreIngreso;
    @Column(name = "consultas_recientes")
    private Integer consultasRecientes;
}
