package com.usuario.reporteCrediticio.Service.dto.reporteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertaDto {
    private String ripo;
    private String descripcion;
    private String nivel;
    private LocalDate fechaGeneracion;
}
