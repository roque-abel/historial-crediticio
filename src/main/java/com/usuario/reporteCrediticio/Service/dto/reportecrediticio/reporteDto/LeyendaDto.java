package com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeyendaDto {
    private Map<String, String> estatusCuenta;
    private Map<String,String> codigosPago;
    private Map<String, String> tiposConsulta;
}
