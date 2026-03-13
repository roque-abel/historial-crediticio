package com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Escala {
    private Double minimo;
    private Double maximo;

}
