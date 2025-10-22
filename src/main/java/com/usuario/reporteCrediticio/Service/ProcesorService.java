package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.ContenedorReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcesorService {

    public ContenedorReporteCreditoDto generarReporte(ClienteDto dto) {
        ContenedorReporteCreditoDto reporteCreditoDto =  this.prosesorGateWay.generarReportCred(dto);
        return reporteCreditoDto;
    }

}
