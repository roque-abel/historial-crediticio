package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.ContenedorReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;


public interface ProsesorGateWay {
    ContenedorReporteCreditoDto generarReportCred(ClienteDto dto);

}
