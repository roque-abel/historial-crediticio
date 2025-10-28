package com.usuario.reporteCrediticio.Service.dto.motordereglas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EscalaDto {
    private Double minimo;
    private Double maximo;
}
