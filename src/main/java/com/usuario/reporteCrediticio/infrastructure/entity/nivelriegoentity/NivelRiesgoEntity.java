package com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "nivel_riesgo")
public class NivelRiesgoEntity {
    @Id
    private Integer id;
    private String idReporte;
    private String estatus;
    private String nivel;
    private String descripcion;

    @Column(name = "puntaje_interno")
    private Double puntajeInterno;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "minima", column = @Column(name = "minima")),
            @AttributeOverride(name = "maxima", column = @Column(name = "maxima")),
    })
    private Escala escala;
    private String categoria;
    private Boolean esApto;

    @Column(name = "probabilidad_aprobacion")
    private Double probabilidadAprobacion;
    private String recomendacion;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "usoCredito", column = @Column(name = "fc_uso_credito")),
            @AttributeOverride(name = "historialPagos", column = @Column(name = "fc_historial_pagos")),
            @AttributeOverride(name = "ingresosEstimados", column = @Column(name = "fc_ingresos_estimados")),
            @AttributeOverride(name = "deudaTotal", column = @Column(name = "fc_deuda_total")),
            @AttributeOverride(name = "porcentajeDeudaSobreIngreso", column = @Column(name = "fc_porcentaje_deuda")),
            @AttributeOverride(name = "consultasRecientes", column = @Column(name = "fc_consultas_recientes"))
    })
    private FactorClave factorClave;
    @Column(name = "evaluado_por")
    private String evaluadoPor;

    @Column(name = "fecha_evaluacion")
    private Date fechaEvaluacion;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.fechaCreacion = now;
        this.fechaActualizacion = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new Date();
    }

}
