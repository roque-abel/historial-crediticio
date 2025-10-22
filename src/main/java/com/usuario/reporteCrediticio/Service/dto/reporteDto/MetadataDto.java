package com.usuario.reporteCrediticio.Service.dto.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetadataDto {
    private Integer numeroReporte;
    private Date fechaEmision;
    private String tipoReporte;
    private Double version;
}
