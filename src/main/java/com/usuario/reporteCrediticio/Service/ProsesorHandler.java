package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.NivelRiesgoRepository;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ReporteCreditoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ProsesorHandler {
    @Autowired
    private ProsesorService service;
    @Autowired
    private ReporteCreditoRepository  reporteCreditoRepository;

    public boolean esVigente(Integer diasVigencia) {
        return this.reporteCreditoRepository.estaVigente(diasVigencia);
    }

    public NivelRiesgoDto calcularNivelRiesgo(InformacionPersonalDto  informacionPersonalDto) {

        Boolean esVigente = this.esVigente(34);

        boolean reporteGuardado = this.service.guardarReporte(reporteCreditoDto);
        log.info("Reporte de Credito reporteGuardado: {}", reporteGuardado);

        NivelRiesgoDto nivelRiesgoDto = this.service.calrcularNivelDeRiesgo(reporteCreditoDto);
        log.info("Nivel de riesgo generado: {}", nivelRiesgoDto);

        boolean nivelDeRiesgoGuardado = this.service.guardarNivelDeRiesgo(nivelRiesgoDto);
        log.info("Nivel de riesgo Guardado: {}", nivelDeRiesgoGuardado);

        return nivelRiesgoDto;
    }
}
