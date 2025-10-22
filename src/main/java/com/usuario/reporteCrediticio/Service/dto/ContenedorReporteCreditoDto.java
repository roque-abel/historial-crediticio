package com.usuario.reporteCrediticio.Service.dto;

import com.usuario.reporteCrediticio.Service.dto.reporteDto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContenedorReporteCreditoDto {
    private Integer clienteId;
    private String clienteName;
    private ReporteCrediticioDto reporteCredito;
    private ResumenGeneralDto resumenGeneral;
    private ScoreCrediticioDto scoreCrediticio;
    private List<CuentaDetalladaDto> cuentasDetalladas;
    private List<ConsultaRealizadaDto> consultasRealizadas;
    private List<AlertaDto>  alertas;
    private ResumenPorTipoCreditoDto resumenPorTipoCredito;
    private CreditoAutomotrizDto creditoAutomotriz;
    private CreditoHipotecarioDto  creditoHipotecario;
    private LeyendaDto leyendas;
    private InformacionContactoDto informacionContacto;
}
