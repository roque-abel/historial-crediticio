package com.usuario.reporteCrediticio.controller.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DireccionRequest {
    @NotBlank(message = "La calle es obligatoria")
    @Size(max = 100, message = "La colonia no puede exceder 100 caracteres")
    private String calle;
    private Integer numeroExterior;
    @NotBlank(message = "La colonia es obligatoria")
    @Size(max = 100, message = "La colonia no puede exceder 100 caracteres")
    private String colonia;
    @NotNull(message = "El codigo postal eso obligatorio")
    @Digits(integer = 5, fraction = 0, message = "El código postal debe tener 5 dígitos")
    private Integer codigoPostal;
    @NotBlank(message = "La ciudad debe ser obligatoria")
    @Size(max = 50, message = "La ciudad no debe exceder 50 carateres")
    private String ciudad;
    @NotBlank(message = "El estado debe ser obligatorio")
    @Size(max = 50,message = "El estado no debe exceder 50 caracteres")
    private String estado;
}
