package com.usuario.prosesor.infrastructure.burogatewey;

import com.usuario.prosesor.infrastructure.entity.ClientEntity;
import com.usuario.prosesor.infrastructure.entity.ReporteCrediticioEntity;
import com.usuario.prosesor.infrastructure.interfaz.ProsesorGateWay;
import com.usuario.prosesor.infrastructure.mapeo.Mapeo;
import com.usuario.prosesor.service.dto.ClienteDto;
import com.usuario.prosesor.service.dto.ReporteCrediticioDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
@AllArgsConstructor
public class HttpBuroGateway implements ProsesorGateWay {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Mapeo mapeo;

    @Override
    public ReporteCrediticioDto generarReportCred(ClienteDto dto) {
        String url = "http://127.0.0.1:3000/v1/reporte-crediticio/{id}";
        ClientEntity entity = this.mapeo.dtoToEntity(dto);
        ReporteCrediticioEntity reporteCrediticioEntity = this.restTemplate.getForObject(url, ReporteCrediticioEntity.class, entity.getClienteId());
        System.out.println("reporte infrastructura:" + reporteCrediticioEntity);

        return reporteCrediticioDto;
    }
}

