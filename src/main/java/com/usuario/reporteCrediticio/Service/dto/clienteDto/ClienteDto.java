package com.usuario.reporteCrediticio.Service.dto.clienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {
    private InformacionPersonalDto informacionPersonalDto;
    private DireccionDto direccionDto;
    private IdentificacionDto identificacionDto;
}
