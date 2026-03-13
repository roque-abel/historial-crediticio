package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreCrediticioDto {
    private Integer puntaje;
    private String escala;
    private Integer percentil;
    private String interpretacion;
    private List<String> factoresInfluencia;
}
