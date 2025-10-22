package com.usuario.reporteCrediticio.controller;

import com.usuario.reporteCrediticio.Service.ProsesorService;
import com.usuario.reporteCrediticio.Service.dto.ContenedorReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.ClienteDto;
import com.usuario.reporteCrediticio.controller.mapeo.MapeoController;
import com.usuario.reporteCrediticio.controller.request.ClienteRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProsesorController {
    @Autowired
    private MapeoController mapeo;
    @Autowired
    private ProsesorService service;

    @PostMapping("v1/procesor")
    public ResponseEntity<ContenedorReporteCreditoDto> generarReporte( @RequestBody ClienteRequest request){
        ClienteDto clienteDtodto = this.mapeo.clienteRequestToDto(request);
        ContenedorReporteCreditoDto contenedorReporteCreditoDto = this.service.generarReporte(clienteDtodto);
        return  ResponseEntity.ok(contenedorReporteCreditoDto);
    }

}
