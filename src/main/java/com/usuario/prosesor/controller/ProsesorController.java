package com.usuario.prosesor.controller;

import com.usuario.prosesor.controller.mapeo.MapeoController;
import com.usuario.prosesor.controller.request.ClienteRequest;
import com.usuario.prosesor.service.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProsesorController {
    @Autowired
    private MapeoController mapeo;

    @PostMapping("v1/cliente")
    public ResponseEntity<ClienteDto> generarReporte(@Validated @RequestBody ClienteRequest request) {
        ClienteDto clienteDto = this.mapeo.requestToDto(request);
        return ResponseEntity.ok(clienteDto);
    }
}
