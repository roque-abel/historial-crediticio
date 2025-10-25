package com.usuario.reporteCrediticio.infrastructure.entity.reporte;

import com.usuario.reporteCrediticio.Service.dto.reporteDto.HistorialPagosDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaDetalladaEntity {
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
