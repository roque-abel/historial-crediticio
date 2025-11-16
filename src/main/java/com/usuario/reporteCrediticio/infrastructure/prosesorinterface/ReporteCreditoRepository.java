package com.usuario.reporteCrediticio.infrastructure.prosesorinterface;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;

public interface ReporteCreditoRepository {
    boolean guardarReporte(ReporteCreditoDto reporteCreditoDto);
    boolean estaVigente(Integer diasVigencia);
}
