package com.usuario.reporteCrediticio.infrastructure.repository;

import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.ReporteCreditoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProsesorRepository extends MongoRepository<ReporteCreditoEntity, String> {

    ReporteCreditoEntity findByInformacionPersonalIdentificacionRfc(String rfc);

}
