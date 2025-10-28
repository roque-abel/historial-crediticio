package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto;

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
    private String idCuenta;
    private String tipoCredito;
    private String institucion;
    private LocalDate fechaApertura;
    private LocalDate fechaUltimoCorte;
    private Double lineaCredito;
    private Double saldoActual;
    private Double saldoVencido;
    private Double pagoMinimo;
    private Double pagoRealizado;
    private Integer diasAtraso;
    private String estatus;
    private String responsabilidad;
    private HistorialPagosDto historialPagos;
}
