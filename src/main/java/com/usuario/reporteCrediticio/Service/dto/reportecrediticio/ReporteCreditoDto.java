package com.usuario.reporteCrediticio.Service.dto.reportecrediticio;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReporteCreditoDto {
    private MetadataDto metadata;
    private InformacionPersonalDto informacionPersonal;
    private ResumenGeneralDto resumenGeneral;
    private ScoreCrediticioDto scoreCrediticio;
    private List<CuentaDetalladaDto> cuentasDetalladas;
    private List<ConsultaRealizadaDto> consultasRealizadas;
    private List<AlertaDto>  alertas;
    private ResumenTipoCreditoDto resumenPorTipoCredito;
    private LeyendaDto leyendas;
    private InformacionContactoDto informacionContacto;
}
