package com.usuario.reporteCrediticio.controller;

import com.usuario.reporteCrediticio.Service.ProsesorHandler;
import com.usuario.reporteCrediticio.Service.ProsesorService;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.controller.mapeo.MapeoController;

import com.usuario.reporteCrediticio.controller.request.InformacionPersonalRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Tag(name = "NIVEL DE RIESGO", description = "Generador de nivel de riesgo de usuario")
public class ProsesorController {
    @Autowired
    private MapeoController mapeo;
    @Autowired
    private ProsesorHandler prosesorHandler;
    @Autowired
    private ProsesorService prosesorService;

    @PostMapping("v1/level-riks")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<NivelRiesgoDto> calcularNivelRiesgo(@Validated @RequestBody InformacionPersonalRequest request){

        log.info("Iniciando generar Reporte de Credito: {}", request.toString() );
        InformacionPersonalDto informacionPersonalDto = this.mapeo.informacionPersonalRequestToDto(request);

        NivelRiesgoDto nivelRiesgoDto = this.prosesorHandler.calcularNivelRiesgo(informacionPersonalDto);

        return  ResponseEntity.ok(nivelRiesgoDto);

    }
}
