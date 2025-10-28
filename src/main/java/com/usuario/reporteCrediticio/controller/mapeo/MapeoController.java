package com.usuario.reporteCrediticio.controller.mapeo;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.NombreDto;
import com.usuario.reporteCrediticio.controller.request.DireccionRequest;
import com.usuario.reporteCrediticio.controller.request.IdentificacionRequest;
import com.usuario.reporteCrediticio.controller.request.InformacionPersonalRequest;
import com.usuario.reporteCrediticio.controller.request.NombreRequest;
import org.springframework.stereotype.Component;

@Component
public class MapeoController {

    public InformacionPersonalDto informacionPersonalRequestToDto(InformacionPersonalRequest inforRequest){

        NombreDto nombredto = this.nombreRequestToDto(inforRequest.getNombre());
        DireccionDto direccionDto = this.direccionRequestToDto(inforRequest.getDireccion());
        IdentificacionDto identificacionDto = this.identificacionRequestToDto(inforRequest.getIdentificacion());

        InformacionPersonalDto.InformacionPersonalDtoBuilder informacionPersonalDtoBuilder = InformacionPersonalDto.builder();
        informacionPersonalDtoBuilder.id(inforRequest.getId());
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
