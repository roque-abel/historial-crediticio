package com.usuario.reporteCrediticio.Service.dto.reportecrediticio;

import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReporteCreditoDto {
    private String idReporte;
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
    private Boolean estatus;
    private String producto;
    private Date fechaCreacion;
    private Date fechaActualizacion;

    public ReporteCreditoDto(Date fechaActualizacion, InformacionPersonalDto informacionPersonal, MetadataDto metadata, ResumenGeneralDto resumenGeneral, ScoreCrediticioDto scoreCrediticio, List<CuentaDetalladaDto> cuentasDetalladas, List<ConsultaRealizadaDto> consultasRealizadas, List<AlertaDto> alertas, ResumenTipoCreditoDto resumenPorTipoCredito, LeyendaDto leyendas, InformacionContactoDto informacionContacto, Boolean estatus, String producto, Date fechaCreacion) {
        this.fechaActualizacion = fechaActualizacion;
        this.informacionPersonal = informacionPersonal;
        this.metadata = metadata;
        this.resumenGeneral = resumenGeneral;
        this.scoreCrediticio = scoreCrediticio;
        this.cuentasDetalladas = cuentasDetalladas;
        this.consultasRealizadas = consultasRealizadas;
        this.alertas = alertas;
        this.resumenPorTipoCredito = resumenPorTipoCredito;
        this.leyendas = leyendas;
        this.informacionContacto = informacionContacto;
        this.estatus = estatus;
        this.producto = producto;
        this.fechaCreacion = fechaCreacion;
    }
}
