package com.usuario.reporteCrediticio.controller;

import com.usuario.reporteCrediticio.controller.request.ClienteRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProcesorController {

    @PostMapping("v1/procesor")
    public ResponseEntity<String> generarReporte( @RequestBody ClienteRequest request){

    }

}
