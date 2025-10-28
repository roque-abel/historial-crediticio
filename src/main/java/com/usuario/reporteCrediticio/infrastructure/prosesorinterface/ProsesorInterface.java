package com.usuario.reporteCrediticio.infrastructure.prosesorinterface;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;

public interface ProsesorInterface {
    boolean guardarReporte(ReporteCreditoDto reporteCreditoDto);
}
