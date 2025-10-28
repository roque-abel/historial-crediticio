package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DireccionDto {
    private String calle;
    private Integer numeroExterior;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;
    private String estado;
}

