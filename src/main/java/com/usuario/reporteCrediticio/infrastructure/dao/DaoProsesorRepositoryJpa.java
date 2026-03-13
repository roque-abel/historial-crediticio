package com.usuario.reporteCrediticio.infrastructure.dao;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.infrastructure.entity.CatVigenciaEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.NivelRiesgoEntity;
import com.usuario.reporteCrediticio.infrastructure.mapeo.Mapeo;
import com.usuario.reporteCrediticio.infrastructure.prosesorinterface.NivelRiesgoRepository;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorCatVigenciaRepository;
import com.usuario.reporteCrediticio.infrastructure.repository.ProsesorNivelRiesgoRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Slf4j
public class DaoProsesorRepositoryJpa implements NivelRiesgoRepository {
    @Autowired
    private ProsesorNivelRiesgoRepositoryJpa prosesorNivelRiesgoRepositoryJpa;
    @Autowired
    private Mapeo mapeo;
    @Autowired
    ProsesorCatVigenciaRepository prosesorCatVigenciaRepository;

    @Override
    public boolean guardarNivelDeRiesgo(NivelRiesgoDto nivelRiesgoDto) {
        boolean guardado = false;
        try {
            NivelRiesgoEntity nivelRiesgoEntity = this.mapeo.nivelRiesgoDtoToEntity(nivelRiesgoDto);
            log.info("nivel de riesgo mapeo={}", nivelRiesgoEntity);
            //retornar id de reporte
            //como sabes que id de reporte estas retornando del objeto guardado
            NivelRiesgoEntity nivelRiesgoEntityGuardado = this.prosesorNivelRiesgoRepositoryJpa.save(nivelRiesgoEntity);

            guardado = true;
        } catch (Exception e) {
            log.info("no se pudo guardar nivel de riesgo: {}", e.getMessage());
        }
        return guardado;
    }

    @Override
    public Boolean generarDiasVigencia(String idReporte) {
        Boolean guardado = false;
        try {
            CatVigenciaEntity catVigenciaEntity = this.mapeo.catVigenciaDtoToEntity(idReporte);
            this.prosesorCatVigenciaRepository.save(catVigenciaEntity);
            guardado = true;
        }catch (Exception e){
            log.info("no se pudo guardar catalogo de vigencias: {}", e.getMessage());
        }
        return guardado;
    }

}
