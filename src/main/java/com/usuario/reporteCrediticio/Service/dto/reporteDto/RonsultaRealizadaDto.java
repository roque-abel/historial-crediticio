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
public class RonsultaRealizadaDto {
    private LocalDate fecha;
    private String institucion;
    private String tipoConsulta;
    private String motivo;
}
