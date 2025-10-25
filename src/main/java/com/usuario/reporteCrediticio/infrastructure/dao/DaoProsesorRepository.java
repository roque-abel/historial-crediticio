package com.usuario.reporteCrediticio.infrastructure.dao;

import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;
import com.usuario.reporteCrediticio.infrastructure.entity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.mapeo.Mapeo;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.ProsesorInterface;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class DaoProsesorRepository implements ProsesorInterface {
    @Autowired
    private ProsesorRepository prosesorRepository;
    @Autowired
    private Mapeo mapeo;

    @Override
    public void guardarReporte(ReporteCreditoDto reporteCreditoDto) {
        ReporteCreditoEntity  reporteCreditoEntity = this.mapeo.reporteCreditoDtoToEntity(reporteCreditoDto);
        this.prosesorRepository.save(reporteCreditoEntity);
    }
}
