package com.usuario.reporteCrediticio.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequest {
    private Integer clienteId;
    private InformacionPersonalRequest informacionPersonalRequest;
    private DireccionRequest direccionRequest;
    private IdentificacionRequest identificacionRequest;
}
