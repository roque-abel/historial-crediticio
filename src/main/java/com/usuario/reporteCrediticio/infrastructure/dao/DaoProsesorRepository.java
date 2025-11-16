package com.usuario.reporteCrediticio.infrastructure.dao;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.NivelRiesgoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.mapeo.Mapeo;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ReporteCreditoRepository;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorRepository;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class DaoProsesorRepository implements ReporteCreditoRepository {
    @Autowired
    private ProsesorRepository prosesorRepository;
    @Autowired
    private Mapeo mapeo;


    @Override
    public boolean guardarReporte(ReporteCreditoDto reporteCreditoDto) {
        boolean guardado = false;
        try {
            ReporteCreditoEntity reporteCreditoEntity = this.mapeo.reporteCreditoDtoToEntity(reporteCreditoDto);
            log.info("reporteCreditoEntity={}", reporteCreditoEntity);
            this.prosesorRepository.save(reporteCreditoEntity);
            guardado = true;
        }catch (Exception e){
            log.info("no se pudo guardar reporteCreditoEntity: {}", e.getMessage());
        }
        return  guardado;
    }


    @Override
    public boolean estaVigente(Integer diasVigencia) {
        this.prosesorRepository.findAll();
        return true;
    }

}
