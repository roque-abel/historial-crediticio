package com.usuario.reporteCrediticio.infrastructure.prosesorinterface;

import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;

public interface ProsesorInterface {
    boolean guardarReporte(ReporteCreditoDto reporteCreditoDto);
}
