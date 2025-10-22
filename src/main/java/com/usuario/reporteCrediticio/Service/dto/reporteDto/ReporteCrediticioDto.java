package com.usuario.reporteCrediticio.Service.dto.reporteDto;

import com.usuario.reporteCrediticio.Service.dto.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReporteCrediticioDto {
    private MetadataDto metadata;
    private InformacionPersonalDto informacionPersonal;
    private DireccionDto direccion;
    private IdentificacionDto identificacion;
}
