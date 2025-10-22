package com.usuario.reporteCrediticio.Service.dto.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaDetalladaDto {
    private Integer idCuenta;
    private String tipoCredito;
    private String institucion;
    private LocalDate fechaApertura;
    private LocalDate fechaUltimoCorte;
    private double lineaCredito;
    private double saldoActual;
    private double saldoVencido;
    private double pagoMinimo;
    private double pagoRealizado;
    private Integer diasAtraso;
    private String estatus;
    private String responsabilidad;
    private HistorialPagosDto historialPagosDto;
}
