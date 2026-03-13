package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.CatVigenciaDto;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.InformacionContactoDto;
import com.usuario.reporteCrediticio.infrastructure.gateway.ProsesorGateWay;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.NivelRiesgoRepository;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ReporteCreditoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProsesorService {
    @Autowired
    private ProsesorGateWay prosesorGateWay;
    @Autowired
    private ReporteCreditoRepository reporteCreditoRepository;
    @Autowired
    private NivelRiesgoRepository nivelRiesgoRepository;

    public ReporteCreditoDto calcularReporte(InformacionPersonalDto dto) {
        return this.prosesorGateWay.calcularReportCred(dto);
    }

    public boolean guardarReporte(ReporteCreditoDto reporteCreditoDto) {
        return this.reporteCreditoRepository.guardarReporte(reporteCreditoDto);
    }

    public NivelRiesgoDto calrcularNivelDeRiesgo(ReporteCreditoDto reporteCreditoDto) {
        return this.prosesorGateWay.calcularNivelRiesgoDto(reporteCreditoDto);
    }

    public boolean guardarNivelDeRiesgo(NivelRiesgoDto nivelRiesgoDto) {
        return this.nivelRiesgoRepository.guardarNivelDeRiesgo(nivelRiesgoDto);
    }

    public ReporteCreditoDto buscarPorRfc(InformacionPersonalDto informacionPersonalDto){
        return  this.reporteCreditoRepository.buscarPorRfc(informacionPersonalDto);
    }

    public CatVigenciaDto obtenerVigencia(String producto){
        return this.nivelRiesgoRepository.obtenerVigencia(producto);
    }


}
