package com.usuario.reporteCrediticio.controller.mapeo;

import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.controller.request.ClienteRequest;
import com.usuario.reporteCrediticio.controller.request.DireccionRequest;
import com.usuario.reporteCrediticio.controller.request.IdentificacionRequest;
import com.usuario.reporteCrediticio.controller.request.InformacionPersonalRequest;
import org.springframework.stereotype.Component;

@Component
public class MapeoController {

    public ClienteDto clienteRequestToDto(ClienteRequest clienteRequest){

        InformacionPersonalDto informacionPersonalDto = this.informacionPersonalRequestToDto(clienteRequest.getInformacionPersonalRequest());
        DireccionDto direccionDto = this.direccionRequestToDto(clienteRequest.getDireccionRequest());
        IdentificacionDto identificacionDto = this.identificacionRequestToDto(clienteRequest.getIdentificacionRequest());

        ClienteDto.ClienteDtoBuilder clienteDtoBuilder = ClienteDto.builder();
        clienteDtoBuilder.informacionPersonalDto(informacionPersonalDto);
        clienteDtoBuilder.direccionDto(direccionDto);
        clienteDtoBuilder.identificacionDto(identificacionDto);
        return clienteDtoBuilder.build();

    }

    private DireccionDto direccionRequestToDto(DireccionRequest direccionRequest){
        DireccionDto.DireccionDtoBuilder direccionDtoBuilder = DireccionDto.builder();
        direccionDtoBuilder.calle(direccionRequest.getCalle());
        direccionDtoBuilder.numeroExterior(direccionRequest.getNumeroExterior());
        direccionDtoBuilder.colonia(direccionRequest.getColonia());
        direccionDtoBuilder.ciudad(direccionRequest.getCiudad());
        direccionDtoBuilder.estado(direccionRequest.getEstado());
        return direccionDtoBuilder.build();
    }

    private IdentificacionDto identificacionRequestToDto(IdentificacionRequest identificacionRequest){
        IdentificacionDto.IdentificacionDtoBuilder identificacionDtoBuilder = IdentificacionDto.builder();
        identificacionDtoBuilder.rfc(identificacionRequest.getRfc());
        identificacionDtoBuilder.curp(identificacionRequest.getCurp());
        identificacionDtoBuilder.fechaDeNacimiento(identificacionRequest.getFechaDeNacimiento());
        return identificacionDtoBuilder.build();
    }

    private InformacionPersonalDto informacionPersonalRequestToDto(InformacionPersonalRequest InformacionPersonalRequest){
        InformacionPersonalDto.InformacionPersonalDtoBuilder informacionPersonalDtoBuilder = InformacionPersonalDto.builder();
        informacionPersonalDtoBuilder.nombre(InformacionPersonalRequest.getNombre());
        informacionPersonalDtoBuilder.apellidoParteno(InformacionPersonalRequest.getApellidoParteno());
        informacionPersonalDtoBuilder.apellidoMaterno(InformacionPersonalRequest.getApellidoMaterno());
        return informacionPersonalDtoBuilder.build();

    }


}
