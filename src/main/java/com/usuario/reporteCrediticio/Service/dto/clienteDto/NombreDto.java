package com.usuario.reporteCrediticio.Service.dto.clienteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NombreDto {
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
}
