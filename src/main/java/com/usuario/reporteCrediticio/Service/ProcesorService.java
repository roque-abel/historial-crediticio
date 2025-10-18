package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProcesorService {
    public ReporteCrediticioDto generarReporte(ClienteDto dto) {
        ReporteCrediticioDto crediticioDto =  this.prosesorGateWay.generarReportCred(dto);
        return crediticioDto;
    }

}
