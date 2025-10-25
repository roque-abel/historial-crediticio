package com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacionContactoEntity {
    private String telefonoAtencion;
    private String paginaWeb;
    private String email;
    private String horarioAtencion;
}
