package com.usuario.prosesor.controller.mapeo;

import com.usuario.prosesor.controller.request.ClienteRequest;
import com.usuario.prosesor.service.dto.ClienteDto;
import org.springframework.stereotype.Component;

@Component
public class MapeoController {

    public ClienteDto requestToDto(ClienteRequest http){
        ClienteDto.ClienteDtoBuilder clienteDtoBuilder = ClienteDto.builder();
        clienteDtoBuilder.clienteId(http.getClienteId());
        clienteDtoBuilder.nombre(http.getNombre());
        clienteDtoBuilder.apellidos(http.getApellidos());
        clienteDtoBuilder.colonia(http.getColonia());
        clienteDtoBuilder.codigoPostal(http.getCodigoPostal());
        clienteDtoBuilder.ciudad(http.getCiudad());
        clienteDtoBuilder.estado(http.getEstado());
        clienteDtoBuilder.curp(http.getCurp());
        clienteDtoBuilder.rfc(http.getRfc());
        clienteDtoBuilder.fechaNacimiento(http.getFechaNacimiento());
        return clienteDtoBuilder.build();
    }

}
