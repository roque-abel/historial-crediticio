package com.usuario.reporteCrediticio.infrastructure.entity.reporte;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.PeriodoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialPagosEntity {
    private List<PeriodoDto> periodos;
    private String leyenda;
}
