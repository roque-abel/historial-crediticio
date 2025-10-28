package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.MetadataDto;
import com.usuario.reporteCrediticio.infrastructure.gateway.ProsesorGateWay;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ProsesorInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProsesorService {
    @Autowired
    private ProsesorGateWay prosesorGateWay;
    private ProsesorInterface prosesorInterface;

    public ReporteCreditoDto generarReporte(InformacionPersonalDto dto) {
        return this.prosesorGateWay.generarReportCred(dto);
    }

    public boolean guardarReporte(ReporteCreditoDto reporteCreditoDto) {
       return this.prosesorInterface.guardarReporte(reporteCreditoDto);
    }

    public NivelRiesgoDto mostrarNivelDeRiesgo(MetadataDto metadataDto) {
        return this.prosesorGateWay.generarNivelRiesgoDto(metadataDto);
    }
}
