package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.infrastructure.gateway.ProsesorGateWay;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProsesorService {
    @Autowired
    private ProsesorGateWay prosesorGateWay;

    public ReporteCreditoDto generarReporte(InformacionPersonalDto dto) {
        ReporteCreditoDto reporteCreditoDto =  this.prosesorGateWay.generarReportCred(dto);
        return reporteCreditoDto;
    }

}
