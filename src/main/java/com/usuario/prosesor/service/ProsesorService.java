package com.usuario.prosesor.service;

import com.usuario.prosesor.infrastructure.interfaz.ProsesorGateWay;
import com.usuario.prosesor.service.dto.ClienteDto;
import com.usuario.prosesor.service.dto.ReporteCrediticioDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProsesorService {
    @Autowired
    private ProsesorGateWay prosesorGateWay;


    public ReporteCrediticioDto generarReporte(ClienteDto dto) {
        ReporteCrediticioDto crediticioDto =  this.prosesorGateWay.generarReportCred(dto);
         return crediticioDto;
    }
}
