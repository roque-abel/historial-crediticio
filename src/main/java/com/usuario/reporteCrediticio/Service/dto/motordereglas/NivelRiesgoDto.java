package com.usuario.reporteCrediticio.Service.dto.motordereglas;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.MetadataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NivelRiesgoDto {
    private Integer id;
    private String estatus;
    private String nivel;
    private String descripcion;
    private Double puntajeInterno;
    private EscalaDto escala;
    private String categoria;
    private Boolean esApto;
    private Double probabilidadAprobacion;
    private String recomendacion;
    private FactorClaveDto factorClave;
    private String evaluadoPor;
    private Date fechaEvaluacion;

}
