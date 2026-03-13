package com.usuario.reporteCrediticio.infrastructure.prosesorinterface;

import com.usuario.reporteCrediticio.Service.dto.CatVigenciaDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;

public interface ReporteCreditoRepository {
    Boolean guardarReporte(ReporteCreditoDto reporteCreditoDto);
    ReporteCreditoDto buscarPorRfc(InformacionPersonalDto informacionPersonalDto);
    CatVigenciaDto obtenerVigencia(String producto);

}
