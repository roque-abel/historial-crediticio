package com.usuario.reporteCrediticio.controller.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacionPersonalRequest {
    @NotNull(message = "El codigo postal eso obligatorio")
    @Digits(integer = 9, fraction = 0, message = "El código postal debe tener 5 dígitos")
    private Integer id;
    private NombreRequest nombre;
    private DireccionRequest direccion;
    private IdentificacionRequest identificacion;
}
