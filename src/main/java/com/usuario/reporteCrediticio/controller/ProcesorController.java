package com.usuario.reporteCrediticio.controller;

import com.usuario.reporteCrediticio.Service.ProcesorService;
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
public class ProcesorController {
    @Autowired
    private MapeoController mapeo;
    @Autowired
    private ProcesorService service;

    @PostMapping("v1/procesor")
    public ResponseEntity<String> generarReporte( @RequestBody ClienteRequest request){
        ClienteDto dto = this.mapeo.clienteRequestToDto(request);
        this.service.generarReporte();
    }

}
