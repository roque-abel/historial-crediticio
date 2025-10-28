package com.usuario.reporteCrediticio.infrastructure.dao;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.infrastructure.entity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.mapeo.Mapeo;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ProsesorInterface;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class DaoProsesorRepository implements ProsesorInterface {
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
}
