package com.usuario.reporteCrediticio.controller;

import com.usuario.reporteCrediticio.Service.ProsesorService;
import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.controller.mapeo.MapeoController;

import com.usuario.reporteCrediticio.controller.request.InformacionPersonalRequest;
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

    @PostMapping("v1/reporte")
    public ResponseEntity<ReporteCreditoDto> generarReporte(@RequestBody InformacionPersonalRequest request){
        log.info("Iniciando generar Reporte de Credito: {}", request.toString() );
        InformacionPersonalDto clienteDtodto = this.mapeo.informacionPersonalRequestToDto(request);
        ReporteCreditoDto contenedorReporteCreditoDto = this.service.generarReporte(clienteDtodto);
        return  ResponseEntity.ok(contenedorReporteCreditoDto);
    }

}
