package com.usuario.prosesor.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class ClienteRequest {
    @NotNull(message = "El codigo postal eso obligatorio")
    @Digits(integer = 9, fraction = 0, message = "El código postal debe tener 5 dígitos")
    private Integer clienteId;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 100, message = "Los apellidos no pueden exceder 100 caracteres")
    private String apellidos;

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

    @Pattern(regexp = "^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$", message = "RFC inválido")
    private String rfc;

    @Pattern(regexp = "^[A-Z]{4}[0-9]{6}[A-Z]{6}[0-9A-Z]{2}$", message = "CURP inválida")
    private String curp;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;
}
