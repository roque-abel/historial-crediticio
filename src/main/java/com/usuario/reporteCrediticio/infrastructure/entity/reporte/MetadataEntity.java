package com.usuario.reporteCrediticio.infrastructure.entity.reporte;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MetadataEntity {
    private String numeroReporte;
    private Date fechaEmision;
    private String tipoReporte;
    private Double version;
}
