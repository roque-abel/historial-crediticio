package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class HttpBuroGateway implements ProsesorGateWay {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ReporteCreditoDto generarReportCred(InformacionPersonalDto informacionPersonalDto) {
        log.info("Iniciando Reporte Credito, gateway:{}",informacionPersonalDto.toString() );
        String url = "http://127.0.0.1:3000/v1/reporte/{id}";
        ReporteCreditoDto contenedorReporteCreditoDto = this.restTemplate.getForObject(url, ReporteCreditoDto.class, informacionPersonalDto.getId());
        log.info("ContenedorReporteCreditoDto: {}", contenedorReporteCreditoDto);
        return contenedorReporteCreditoDto;
    }
}
