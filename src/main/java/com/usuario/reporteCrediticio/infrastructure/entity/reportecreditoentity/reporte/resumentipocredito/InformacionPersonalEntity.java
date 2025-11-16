package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.resumentipocredito;

import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.DireccionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.IdentificacionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.NombreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacionPersonalEntity {
    private Integer id;
    private NombreEntity nombre;
    private DireccionEntity direccion;
    private IdentificacionEntity identificacion;

}
