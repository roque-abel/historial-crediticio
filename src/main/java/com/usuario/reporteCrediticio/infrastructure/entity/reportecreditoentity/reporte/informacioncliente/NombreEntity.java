package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NombreEntity {
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
}
