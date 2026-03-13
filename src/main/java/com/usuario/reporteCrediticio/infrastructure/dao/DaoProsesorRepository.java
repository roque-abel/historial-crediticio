package com.usuario.reporteCrediticio.infrastructure.dao;

import com.usuario.reporteCrediticio.Service.dto.CatVigenciaDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.mapeo.Mapeo;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ReporteCreditoRepository;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorReporteCrediticioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class DaoProsesorRepository implements ReporteCreditoRepository {
    @Autowired
    private ProsesorReporteCrediticioRepository prosesorRepositoryMongo;
    @Autowired
    private Mapeo mapeo;



    @Override
    public Boolean guardarReporte(ReporteCreditoDto reporteCreditoDto) {
        boolean guardado = false;
        try {
            ReporteCreditoEntity reporteCreditoEntity = this.mapeo.reporteCreditoDtoToEntity(reporteCreditoDto);
            log.info("reporteCreditoEntity={}", reporteCreditoEntity);
            this.prosesorRepositoryMongo.save(reporteCreditoEntity);
            guardado = true;
        }catch (Exception e){
            log.info("no se pudo guardar reporteCreditoEntity: {}", e.getMessage());
        }
        return  guardado;
    }

    @Override
    public ReporteCreditoDto buscarPorRfc(InformacionPersonalDto informacionPersonalDto) {
        IdentificacionDto ident = informacionPersonalDto.getIdentificacion();
        String rfc = ident.getRfc();
        ReporteCreditoEntity reporteCreditoEntity = this.prosesorRepositoryMongo.findByInformacionPersonalIdentificacionRfc(rfc);
        ReporteCreditoDto reporteCreditoDto = this.mapeo.reporteCreditoEnyotyToDto(reporteCreditoEntity);
        return reporteCreditoDto;
    }

    @Override
    public CatVigenciaDto obtenerVigencia(String idProducto) {
        return null;
    }


}
