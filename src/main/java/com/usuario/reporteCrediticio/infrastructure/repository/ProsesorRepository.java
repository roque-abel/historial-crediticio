package com.usuario.reporteCrediticio.infrastructure.repository;

import com.usuario.reporteCrediticio.infrastructure.entity.ReporteCreditoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProsesorRepository extends MongoRepository<ReporteCreditoEntity, String> {

}
