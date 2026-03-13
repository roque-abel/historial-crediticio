package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DireccionEntity {
    private String calle;
    private Integer numeroExterior;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;
    private String estado;

}
