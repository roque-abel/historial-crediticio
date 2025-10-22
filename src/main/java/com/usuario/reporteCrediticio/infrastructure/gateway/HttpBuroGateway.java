package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.ContenedorReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;
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
    public ContenedorReporteCreditoDto generarReportCred(ClienteDto dto) {
        String url = "http://127.0.0.1:3000/v1/reporte-crediticio/{id}";
        ContenedorReporteCreditoDto contenedorReporteCreditoDto = this.restTemplate.getForObject(url, ContenedorReporteCreditoDto.class, dto.getClienteId());
        log.info("ContenedorReporteCreditoDto: {}", contenedorReporteCreditoDto);
        return contenedorReporteCreditoDto;
    }
}
