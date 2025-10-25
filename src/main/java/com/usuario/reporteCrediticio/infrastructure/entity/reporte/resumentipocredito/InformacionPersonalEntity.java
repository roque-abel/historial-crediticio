package com.usuario.reporteCrediticio.infrastructure.entity.reporte.resumentipocredito;

import com.usuario.reporteCrediticio.Service.dto.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.NombreDto;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.DireccionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.IdentificacionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.NombreEntity;
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
