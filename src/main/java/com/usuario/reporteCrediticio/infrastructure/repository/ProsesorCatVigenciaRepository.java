package com.usuario.reporteCrediticio.infrastructure.repository;

import com.usuario.reporteCrediticio.infrastructure.entity.CatVigenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProsesorCatVigenciaRepository extends JpaRepository<CatVigenciaEntity, Integer>{
}
