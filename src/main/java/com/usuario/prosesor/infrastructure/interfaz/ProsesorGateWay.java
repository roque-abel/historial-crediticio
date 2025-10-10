package com.usuario.prosesor.infrastructure.interfaz;

import com.usuario.prosesor.service.dto.ClienteDto;
import com.usuario.prosesor.service.dto.ReporteCrediticioDto;

public interface ProsesorGateWay {

    ReporteCrediticioDto generarReportCred(ClienteDto dto);
}
