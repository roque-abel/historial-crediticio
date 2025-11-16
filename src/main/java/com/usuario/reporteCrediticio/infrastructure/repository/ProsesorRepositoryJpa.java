package com.usuario.reporteCrediticio.infrastructure.repository;

import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.NivelRiesgoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProsesorRepositoryJpa extends JpaRepository<NivelRiesgoEntity, Integer> {
}
