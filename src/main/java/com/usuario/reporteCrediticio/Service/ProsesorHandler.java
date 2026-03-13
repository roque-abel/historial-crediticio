package com.usuario.reporteCrediticio.Service;

import com.usuario.reporteCrediticio.Service.dto.CatVigenciaDto;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ReporteCreditoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
public class ProsesorHandler {
    @Autowired
    private ProsesorService service;

  /*  public Boolean esVigente(InformacionPersonalDto informacionPersonalDto) {

        ReporteCreditoDto reporteCreditoDto = this.buscarReporte(informacionPersonalDto);

        Date fechaCreacion = reporteCreditoDto.getFechaCreacion();

        CatVigenciaDto vigenciaDto = this.obtenerVigenciaDto(reporteCreditoDto);

        //se realiza una coversion de Date a LocalDate
        LocalDate fechaDeCreacion = fechaCreacion.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVigencia = fechaActual.minusDays(vigenciaDto.getDiasVigencia());

        if (fechaDeCreacion.isAfter(fechaVigencia)) {
            log.info("el reporte esta vigente");
            return true;
        }


    }*/

    public ReporteCreditoDto buscarReporte(InformacionPersonalDto informacionPersonalDto) {
        ReporteCreditoDto reporteCreditoDto = this.service.buscarPorRfc(informacionPersonalDto);
        if (reporteCreditoDto == null) {
            log.warn("No se encontró reporte para el RFC proporcionado");
        }
        log.warn("en encotro reporte credito por rfc"+ reporteCreditoDto);
        return reporteCreditoDto;
    }
    public CatVigenciaDto obtenerVigenciaDto(InformacionPersonalDto informacionPersonalDto) {
        ReporteCreditoDto reporteCreditoDto = this.buscarReporte(informacionPersonalDto);
        CatVigenciaDto vigenciaDto = this.service.obtenerVigencia(reporteCreditoDto.getProducto());
        if (vigenciaDto == null) {
            log.warn("El reporte encontrado no tiene fecha de creación");
        }
        log.warn("vigencia del reporte:" + " "+ vigenciaDto.getDiasVigencia());
        return vigenciaDto;
    }



    public NivelRiesgoDto calcularNivelRiesgo(InformacionPersonalDto informacionPersonalDto) {


        ReporteCreditoDto reporteCreditoDto = this.service.calcularReporte(informacionPersonalDto);

        boolean reporteGuardado = this.service.guardarReporte(reporteCreditoDto);
        log.info("Reporte de Credito reporteGuardado: {}", reporteGuardado);

        NivelRiesgoDto nivelRiesgoDto = this.service.calrcularNivelDeRiesgo(reporteCreditoDto);
        this.service.guardarNivelDeRiesgo(nivelRiesgoDto);
        log.info("Nivel de riesgo generado: {}", nivelRiesgoDto);
/**
 boolean nivelDeRiesgoGuardado = this.service.guardarNivelDeRiesgo(nivelRiesgoDto);
 log.info("Nivel de riesgo Guardado: {}", nivelDeRiesgoGuardado);
 */
        return nivelRiesgoDto;
    }

}
