package com.usuario.prosesor.infrastructure.mapeo;

import com.usuario.prosesor.infrastructure.entity.ClientEntity;
import com.usuario.prosesor.infrastructure.entity.ReporteCrediticioEntity;
import com.usuario.prosesor.service.dto.ClienteDto;
import com.usuario.prosesor.service.dto.ReporteCrediticioDto;
import org.springframework.stereotype.Component;

@Component
public class Mapeo {

    public ClientEntity dtoToEntity(ClienteDto dto) {
        ClientEntity.ClientEntityBuilder clientEntityBuilder = ClientEntity.builder();
        clientEntityBuilder.clienteId(dto.getClienteId());
        clientEntityBuilder.nombre(dto.getNombre());
        clientEntityBuilder.apellidos(dto.getApellidos());
        clientEntityBuilder.colonia(dto.getColonia());
        clientEntityBuilder.codigoPostal(dto.getCodigoPostal());
        clientEntityBuilder.ciudad(dto.getCiudad());
        clientEntityBuilder.estado(dto.getEstado());
        clientEntityBuilder.curp(dto.getCurp());
        clientEntityBuilder.rfc(dto.getRfc());
        clientEntityBuilder.fechaNacimiento(dto.getFechaNacimiento());
        return clientEntityBuilder.build();
    }


    public ReporteCrediticioDto reportEntityToReportDto(ReporteCrediticioEntity entity){
        ReporteCrediticioDto.ReporteCrediticioDtoBuilder dtoBuilder = ReporteCrediticioDto.builder();
        dtoBuilder.clienteId()
    }
}
