package com.usuario.reporteCrediticio.infrastructure.prosesorinterface;

import com.usuario.reporteCrediticio.Service.dto.CatVigenciaDto;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;

public interface NivelRiesgoRepository {
    boolean guardarNivelDeRiesgo(NivelRiesgoDto nivelRiesgoDto);

    Boolean generarDiasVigencia(String idProducto);


}
