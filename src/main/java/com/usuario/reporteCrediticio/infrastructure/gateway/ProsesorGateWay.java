package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;


public interface ProsesorGateWay {
    ReporteCreditoDto calcularReportCred(InformacionPersonalDto dto);
    NivelRiesgoDto calcularNivelRiesgoDto(ReporteCreditoDto reporteCreditoDto);

}
