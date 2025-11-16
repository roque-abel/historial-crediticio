package com.usuario.reporteCrediticio.infrastructure.gateway;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.MetadataDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class HttpProsesorGateway implements ProsesorGateWay {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ReporteCreditoDto calcularReportCred(InformacionPersonalDto informacionPersonalDto) {
        try {
            String url = "http://127.0.0.1:3000/v1/reporte/{id}";
            ReporteCreditoDto reporteCreditoDto = this.restTemplate.getForObject(url, ReporteCreditoDto.class, informacionPersonalDto.getId());
            log.info("ContenedorReporteCreditoDto: {}", reporteCreditoDto);
            return reporteCreditoDto;
        } catch (Exception e) {
            log.info("Error iniciando Reporte Credito, gateway:{}", e.getMessage());
            throw new RuntimeException("Error iniciando Reporte Credito");
        }
    }

    @Override
    public NivelRiesgoDto calcularNivelRiesgoDto(ReporteCreditoDto reporteCreditoDto) {
        try {
            String url = "http://127.0.0.1:3000/v1/motor-de-reglas";
            NivelRiesgoDto nivelRiesgoDto = this.restTemplate.postForObject(url, reporteCreditoDto, NivelRiesgoDto.class );
            log.info("nivel de riesgo: {}", nivelRiesgoDto);
            return nivelRiesgoDto;
        } catch (Exception e) {
            log.info("Error iniciando nivel de riesgo, gateway:{}", e.getMessage());
            throw new RuntimeException("Error iniciando nivel de riesgo");
        }
    }

}
