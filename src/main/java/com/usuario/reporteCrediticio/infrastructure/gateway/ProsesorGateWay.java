package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;


public interface ProsesorGateWay {
    ReporteCreditoDto generarReportCred(InformacionPersonalDto dto);

}
