package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.MetadataDto;


public interface ProsesorGateWay {
    ReporteCreditoDto generarReportCred(InformacionPersonalDto dto);

    NivelRiesgoDto generarNivelRiesgoDto(MetadataDto metadataDto);

}
