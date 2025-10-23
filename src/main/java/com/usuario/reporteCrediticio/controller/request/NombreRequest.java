package com.usuario.reporteCrediticio.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NombreRequest {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
