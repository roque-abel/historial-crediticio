package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.ContenedorReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;
import com.usuario.reporteCrediticio.infrastructure.gateway.ProsesorGateWay;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProsesorService {
    @Autowired
    private ProsesorGateWay prosesorGateWay;

    public ContenedorReporteCreditoDto generarReporte(ClienteDto dto) {
        ContenedorReporteCreditoDto reporteCreditoDto =  this.prosesorGateWay.generarReportCred(dto);
        return reporteCreditoDto;
    }

}
