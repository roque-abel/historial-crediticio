package com.usuario.reporteCrediticio.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacionPersonalRequest {
    private String nombre;
    private String apellidoParteno;
    private String apellidoMaterno;
}
