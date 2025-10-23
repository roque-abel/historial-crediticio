package com.usuario.reporteCrediticio.controller.mapeo;

import com.usuario.reporteCrediticio.Service.dto.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.NombreDto;
import com.usuario.reporteCrediticio.controller.request.DireccionRequest;
import com.usuario.reporteCrediticio.controller.request.IdentificacionRequest;
import com.usuario.reporteCrediticio.controller.request.InformacionPersonalRequest;
import com.usuario.reporteCrediticio.controller.request.NombreRequest;
import org.springframework.stereotype.Component;

@Component
public class MapeoController {

    public InformacionPersonalDto informacionPersonalRequestToDto(InformacionPersonalRequest inforDto){

        NombreDto nombredto = this.nombreRequestToDto(inforDto.getNombre());
        DireccionDto direccionDto = this.direccionRequestToDto(inforDto.getDireccion());
        IdentificacionDto identificacionDto = this.identificacionRequestToDto(inforDto.getIdentificacion());

        InformacionPersonalDto.InformacionPersonalDtoBuilder informacionPersonalDtoBuilder = InformacionPersonalDto.builder();
        informacionPersonalDtoBuilder.id(inforDto.getId());
        informacionPersonalDtoBuilder.nombre(nombredto);
        informacionPersonalDtoBuilder.direccion(direccionDto);
        informacionPersonalDtoBuilder.identificacion(identificacionDto);
        return informacionPersonalDtoBuilder.build();

    }

    private DireccionDto direccionRequestToDto(DireccionRequest direccionRequest){
        DireccionDto.DireccionDtoBuilder direccionDtoBuilder = DireccionDto.builder();
        direccionDtoBuilder.calle(direccionRequest.getCalle());
        direccionDtoBuilder.numeroExterior(direccionRequest.getNumeroExterior());
        direccionDtoBuilder.colonia(direccionRequest.getColonia());
        direccionDtoBuilder.ciudad(direccionRequest.getCiudad());
        direccionDtoBuilder.estado(direccionRequest.getEstado());
        direccionDtoBuilder.codigoPostal(direccionRequest.getCodigoPostal());
        return direccionDtoBuilder.build();
    }

    private IdentificacionDto identificacionRequestToDto(IdentificacionRequest identificacionRequest){
        IdentificacionDto.IdentificacionDtoBuilder identificacionDtoBuilder = IdentificacionDto.builder();
        identificacionDtoBuilder.rfc(identificacionRequest.getRfc());
        identificacionDtoBuilder.curp(identificacionRequest.getCurp());
        identificacionDtoBuilder.fechaNacimiento(identificacionRequest.getFechaNacimiento());
        return identificacionDtoBuilder.build();
    }

    private NombreDto nombreRequestToDto(NombreRequest nombrerequest){
        NombreDto.NombreDtoBuilder nombreDtoBuilder = NombreDto.builder();
        nombreDtoBuilder.nombre(nombrerequest.getNombre());
        nombreDtoBuilder.apellidoPaterno(nombrerequest.getApellidoPaterno());
        nombreDtoBuilder.apellidoMaterno(nombrerequest.getApellidoMaterno());
        return nombreDtoBuilder.build();

    }


}
