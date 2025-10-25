package com.usuario.reporteCrediticio.infrastructure.repository;

import com.usuario.reporteCrediticio.infrastructure.entity.ReporteCreditoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProsesorRepository extends MongoRepository<ReporteCreditoEntity, Integer> {

}
