package com.usuario.reporteCrediticio.infrastructure.dao;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.NivelRiesgoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.mapeo.Mapeo;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.NivelRiesgoRepository;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class DaoProsesorRepositoryJpa implements NivelRiesgoRepository {
    @Autowired
    private ProsesorRepositoryJpa prosesorRepositoryJpa;
    @Autowired
    private Mapeo mapeo;

    @Override
    public boolean guardarNivelDeRiesgo(NivelRiesgoDto nivelRiesgoDto) {
        boolean guardado = false;
        try {
            NivelRiesgoEntity nivelRiesgoEntity = this.mapeo.nivelRiesgoDtoToEntity(nivelRiesgoDto);
            log.info("nivel de riesgo mapeo={}", nivelRiesgoEntity);
            //retornar id de reporte
            //como sabes que id de reporte estas retornando del objeto guardado
            NivelRiesgoEntity nivelRiesgoEntityGuardado = this.prosesorRepositoryJpa.save(nivelRiesgoEntity);

            guardado = true;
        }catch (Exception e){
            log.info("no se pudo guardar nivel de riesgo: {}", e.getMessage());
        }
        return  guardado;
    }
}
