package com.usuario.reporteCrediticio.Service.dto.clienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacionPersonalDto {
    private Integer id;
    private NombreDto nombre;
    private DireccionDto direccion;
    private IdentificacionDto identificacion;
}
