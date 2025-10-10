package com.usuario.prosesor.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.usuario.prosesor.controller.mapeo.MapeoController;
import com.usuario.prosesor.controller.request.ClienteRequest;
import com.usuario.prosesor.service.ProsesorService;
import com.usuario.prosesor.service.dto.ClienteDto;
import com.usuario.prosesor.service.dto.ReporteCrediticioDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProsesorController {
    @Autowired
    private MapeoController mapeo;
    @Autowired
    private ProsesorService prosesorService;

    @PostMapping("v1/cliente")
    public ResponseEntity<ReporteCrediticioDto> generarReporte(@Validated @RequestBody ClienteRequest request) {
        ClienteDto clienteDto = this.mapeo.requestToDto(request);
        ReporteCrediticioDto reporte = this.prosesorService.generarReporte(clienteDto);
        System.out.println("reporte hasta el controller:" + reporte);
        return ResponseEntity.ok(reporte);
    }
}
