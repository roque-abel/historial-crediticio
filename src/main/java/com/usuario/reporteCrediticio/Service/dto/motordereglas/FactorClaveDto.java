package com.usuario.reporteCrediticio.Service.dto.motordereglas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FactorClaveDto {
    private String usoCredito;
    private String historialPagos;
    private Integer ingresosEstimados;
    private Integer deudaTotal;
    private Double porcentajeDeudaSobreIngreso;
    private Integer consultasRecientes;

}
