package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodoDto {
    private String mes;
    private String estatus;
}
