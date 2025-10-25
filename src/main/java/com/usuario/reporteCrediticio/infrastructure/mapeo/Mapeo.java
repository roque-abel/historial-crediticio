package com.usuario.reporteCrediticio.infrastructure.mapeo;

import com.usuario.reporteCrediticio.Service.dto.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.clienteDto.NombreDto;
import com.usuario.reporteCrediticio.Service.dto.reporteDto.*;
import com.usuario.reporteCrediticio.infrastructure.entity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.*;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.DireccionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.IdentificacionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.InformacionContactoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.NombreEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.resumentipocredito.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapeo {

    public ReporteCreditoEntity reporteCreditoDtoToEntity(ReporteCreditoDto reporteCreditoDto) {

        MetadataEntity metadataEntity = this.metadataDtoToEntity(reporteCreditoDto.getMetadata());
        InformacionPersonalEntity informacionPersonalEntity = this.informacionPersonalDtoToEntity(reporteCreditoDto.getInformacionPersonal());
        ResumenGeneralEntity resumenGeneralEntity = this.resumenGeneralDtoToEntity(reporteCreditoDto.getResumenGeneral());
        ScoreCrediticioEntity scoreCrediticioEntity = this.scoreCrediticioDtoToEntity(reporteCreditoDto.getScoreCrediticio());
        ResumenTipoCreditoEntity resumenTipoCreditoEntity = this.resumenTipoCreditoDtoToEntity(reporteCreditoDto.getResumenPorTipoCredito());
        LeyendaEntity leyendaEntity = this.leyendaDtoToEntity(reporteCreditoDto.getLeyendas());
        InformacionContactoEntity informacionContactoEntity = this.informacionContactoDtoToEntity(reporteCreditoDto.getInformacionContacto());
        List<CuentaDetalladaEntity> cuentaDetalladaEntities = this.listCuentaDetalldaDtoToEntity(reporteCreditoDto.getCuentasDetalladas());
        List<ConsultaRealizadaEntity> consultaRealizadaEntities = this.listConsultaRealizadaDtoToEntity(reporteCreditoDto.getConsultasRealizadas());
        List<AlertaEntity> alertaEntities = this.listAlertaDtoToEntity(reporteCreditoDto.getAlertas());

        ReporteCreditoEntity.ReporteCreditoEntityBuilder reporteCreditoEntityBuilder = ReporteCreditoEntity.builder();
        reporteCreditoEntityBuilder.metadata(metadataEntity);
        reporteCreditoEntityBuilder.informacionPersonal(informacionPersonalEntity);
        reporteCreditoEntityBuilder.leyendas(leyendaEntity);
        reporteCreditoEntityBuilder.scoreCrediticio(scoreCrediticioEntity);
        reporteCreditoEntityBuilder.resumenPorTipoCredito(resumenTipoCreditoEntity);
        reporteCreditoEntityBuilder.resumenGeneral(resumenGeneralEntity);
        reporteCreditoEntityBuilder.informacionContacto(informacionContactoEntity);
        reporteCreditoEntityBuilder.cuentasDetalladas(cuentaDetalladaEntities);
        reporteCreditoEntityBuilder.alertas(alertaEntities);
        reporteCreditoEntityBuilder.consultasRealizadas(consultaRealizadaEntities);
        return  reporteCreditoEntityBuilder.build();

    }

    private List<CuentaDetalladaEntity> listCuentaDetalldaDtoToEntity(List<CuentaDetalladaDto> cuentasDetalladas) {
        return cuentasDetalladas.stream()
                .map(cuenta -> CuentaDetalladaEntity.builder()
                        .idCuenta(cuenta.getIdCuenta())
                        .tipoCredito(cuenta.getTipoCredito())
                        .institucion(cuenta.getInstitucion())
                        .fechaApertura(cuenta.getFechaApertura())
                        .fechaUltimoCorte(cuenta.getFechaUltimoCorte())
                        .lineaCredito(cuenta.getLineaCredito())
                        .saldoActual(cuenta.getSaldoActual())
                        .saldoVencido(cuenta.getSaldoVencido())
                        .pagoMinimo(cuenta.getPagoMinimo())
                        .pagoRealizado(cuenta.getPagoRealizado())
                        .diasAtraso(cuenta.getDiasAtraso())
                        .estatus(cuenta.getEstatus())
                        .responsabilidad(cuenta.getResponsabilidad())
                        .historialPagos(cuenta.getHistorialPagos())
                        .build())
                .collect(Collectors.toList());
    }
    private List<ConsultaRealizadaEntity> listConsultaRealizadaDtoToEntity(List<ConsultaRealizadaDto> consultasRealizadas) {
        return consultasRealizadas.stream()
                .map(consulta -> ConsultaRealizadaEntity.builder()
                                .fecha(consulta.getFecha())
                                .institucion(consulta.getInstitucion())
                                .tipoConsulta(consulta.getTipoConsulta())
                                .motivo(consulta.getMotivo())
                                .build())
                .collect(Collectors.toList());
    }
    private List<AlertaEntity> listAlertaDtoToEntity(List<AlertaDto> alertas) {
        return alertas.stream()
                .map(alerta -> AlertaEntity.builder()
                        .tipo(alerta.getTipo())
                        .descripcion(alerta.getDescripcion())
                        .nivel(alerta.getNivel())
                        .fechaGeneracion(alerta.getFechaGeneracion())
                        .build())
                .collect(Collectors.toList());
    }

    private MetadataEntity metadataDtoToEntity(MetadataDto metadataDto ){

        MetadataEntity.MetadataEntityBuilder metadataBuilderEntity = MetadataEntity.builder();
        metadataBuilderEntity.numeroReporte(metadataDto.getNumeroReporte());
        metadataBuilderEntity.tipoReporte(metadataDto.getTipoReporte());
        metadataBuilderEntity.fechaEmision(metadataDto.getFechaEmision());
        metadataBuilderEntity.version(metadataDto.getVersion());
        return metadataBuilderEntity.build();
    }

    private InformacionPersonalEntity informacionPersonalDtoToEntity(InformacionPersonalDto informacionPersonalDto){

        DireccionEntity direccion = this.direccionDtoToEntity(informacionPersonalDto.getDireccion());
        IdentificacionEntity identificacion = this.identificacionDtoToEntity(informacionPersonalDto.getIdentificacion());
        NombreEntity nombre = this.nombreDtoToEntity(informacionPersonalDto.getNombre());

        InformacionPersonalEntity.InformacionPersonalEntityBuilder infoPersonalBuilderEntity = InformacionPersonalEntity.builder();
        infoPersonalBuilderEntity.id(informacionPersonalDto.getId());
        infoPersonalBuilderEntity.nombre(nombre);
        infoPersonalBuilderEntity.direccion(direccion);
        infoPersonalBuilderEntity.identificacion(identificacion);
        return infoPersonalBuilderEntity.build();
    }

    private DireccionEntity direccionDtoToEntity(DireccionDto direccionDto){
        DireccionEntity.DireccionEntityBuilder direccionBuilderEntity = DireccionEntity.builder();
        direccionBuilderEntity.calle(direccionDto.getCalle());
        direccionBuilderEntity.numeroExterior(direccionDto.getNumeroExterior());
        direccionBuilderEntity.colonia(direccionDto.getColonia());
        direccionBuilderEntity.ciudad(direccionDto.getCiudad());
        direccionBuilderEntity.codigoPostal(direccionDto.getCodigoPostal());
        direccionBuilderEntity.estado(direccionDto.getEstado());
        return direccionBuilderEntity.build();
    }
    private IdentificacionEntity identificacionDtoToEntity(IdentificacionDto identificacionDto){
        IdentificacionEntity.IdentificacionEntityBuilder  identificacionBuilderEntity = IdentificacionEntity.builder();
        identificacionBuilderEntity.rfc(identificacionDto.getRfc());
        identificacionBuilderEntity.curp(identificacionDto.getCurp());
        identificacionBuilderEntity.fechaNacimiento(identificacionDto.getFechaNacimiento());
        return identificacionBuilderEntity.build();
    }
    private NombreEntity nombreDtoToEntity(NombreDto nombreDto){
        NombreEntity.NombreEntityBuilder nombreEntityBuilder = NombreEntity.builder();
        nombreEntityBuilder.nombre(nombreDto.getNombre());
        nombreEntityBuilder.apellidoMaterno(nombreDto.getApellidoMaterno());
        nombreEntityBuilder.apellidoPaterno(nombreDto.getApellidoPaterno());
        return nombreEntityBuilder.build();

    }
    private ResumenGeneralEntity resumenGeneralDtoToEntity(ResumenGeneralDto resumenGeneralDto){
        ResumenGeneralEntity.ResumenGeneralEntityBuilder resumenGeneralEntityBuilder = ResumenGeneralEntity.builder();
        resumenGeneralEntityBuilder.totalCreditos(resumenGeneralDto.getTotalCreditos());
        resumenGeneralEntityBuilder.creditosVigentes(resumenGeneralDto.getCreditosVigentes());
        resumenGeneralEntityBuilder.creditosCerrados(resumenGeneralDto.getCreditosCerrados());
        resumenGeneralEntityBuilder.creditosEnMora(resumenGeneralDto.getCreditosEnMora());
        resumenGeneralEntityBuilder.lineaCreditoTotal(resumenGeneralDto.getLineaCreditoTotal());
        resumenGeneralEntityBuilder.saldoTotalActual(resumenGeneralDto.getSaldoTotalActual());
        resumenGeneralEntityBuilder.pagoMensualTotal(resumenGeneralDto.getPagoMensualTotal());
        resumenGeneralEntityBuilder.porcentajeEndeudamiento(resumenGeneralDto.getPorcentajeEndeudamiento());
        return resumenGeneralEntityBuilder.build();
    }
    private ScoreCrediticioEntity scoreCrediticioDtoToEntity(ScoreCrediticioDto scoreCrediticioDto){
        ScoreCrediticioEntity.ScoreCrediticioEntityBuilder scoreCrediticioEntityBuilder = ScoreCrediticioEntity.builder();
        scoreCrediticioEntityBuilder.puntaje(scoreCrediticioDto.getPuntaje());
        scoreCrediticioEntityBuilder.escala(scoreCrediticioDto.getEscala());
        scoreCrediticioEntityBuilder.percentil(scoreCrediticioDto.getPercentil());
        scoreCrediticioEntityBuilder.interpretacion(scoreCrediticioDto.getInterpretacion());
        scoreCrediticioEntityBuilder.factoresInfluencia(scoreCrediticioDto.getFactoresInfluencia());
        return scoreCrediticioEntityBuilder.build();
    }
    private ResumenTipoCreditoEntity resumenTipoCreditoDtoToEntity(ResumenTipoCreditoDto  resumenTipoCreditoDto){
        TarjetaCreditoEntity tarjetaCreditoEntity = this.tarjetaCreditoDtoToEntity(resumenTipoCreditoDto.getTarjetaCredito());
        CreditoAutomotrizEntity creditoAutomotrizEntity = this.creditoAutomotrizDtoToEntity(resumenTipoCreditoDto.getCreditoAutomotriz());
        CreditoHipotecarioEntity creditoHipotecarioEntity = this.creditoHipotecarioDtoToEntity(resumenTipoCreditoDto.getCreditoHipotecario());

        ResumenTipoCreditoEntity.ResumenTipoCreditoEntityBuilder resumenTipoCreditoEntityBuilder = ResumenTipoCreditoEntity.builder();
        resumenTipoCreditoEntityBuilder.tarjetaCredito(tarjetaCreditoEntity);
        resumenTipoCreditoEntityBuilder.creditoAutomotriz(creditoAutomotrizEntity);
        resumenTipoCreditoEntityBuilder.creditoHipotecario(creditoHipotecarioEntity);
        return  resumenTipoCreditoEntityBuilder.build();

    }
    private TarjetaCreditoEntity tarjetaCreditoDtoToEntity(TarjetaCreditoDto tarjetaCreditoDto){
        TarjetaCreditoEntity.TarjetaCreditoEntityBuilder tarjetaCreditoEntityBuilder = TarjetaCreditoEntity.builder();
        tarjetaCreditoEntityBuilder.totalCuentas(tarjetaCreditoDto.getTotalCuentas());
        tarjetaCreditoEntityBuilder.cuentasVigentes(tarjetaCreditoDto.getCuentasVigentes());
        tarjetaCreditoEntityBuilder.cuentasCerradas(tarjetaCreditoDto.getCuentasCerradas());
        tarjetaCreditoEntityBuilder.cuentasEnMora(tarjetaCreditoDto.getCuentasEnMora());
        tarjetaCreditoEntityBuilder.lineaTotal(tarjetaCreditoDto.getLineaTotal());
        tarjetaCreditoEntityBuilder.saldoTotal(tarjetaCreditoDto.getSaldoTotal());
        tarjetaCreditoEntityBuilder.usoPorcentaje(tarjetaCreditoDto.getUsoPorcentaje());
        return tarjetaCreditoEntityBuilder.build();
    }
    private CreditoAutomotrizEntity creditoAutomotrizDtoToEntity(CreditoAutomotrizDto creditoAutomotrizDto){
        CreditoAutomotrizEntity.CreditoAutomotrizEntityBuilder creditoAutomotrizEntityBuilder = CreditoAutomotrizEntity.builder();
        creditoAutomotrizEntityBuilder.totalCuentas(creditoAutomotrizDto.getTotalCuentas());
        creditoAutomotrizEntityBuilder.cuentasVigentes(creditoAutomotrizDto.getCuentasVigentes());
        creditoAutomotrizEntityBuilder.lineaTotal(creditoAutomotrizDto.getLineaTotal());
        creditoAutomotrizEntityBuilder.saldoTotal(creditoAutomotrizDto.getSaldoTotal());
        creditoAutomotrizEntityBuilder.usoPorcentaje(creditoAutomotrizDto.getUsoPorcentaje());
        return creditoAutomotrizEntityBuilder.build();
    }
    private CreditoHipotecarioEntity creditoHipotecarioDtoToEntity(CreditoHipotecarioDto creditoHipotecarioDto){
        CreditoHipotecarioEntity.CreditoHipotecarioEntityBuilder creditoHipotecarioEntityBuilder = CreditoHipotecarioEntity.builder();
        creditoHipotecarioEntityBuilder.totalCuentas(creditoHipotecarioDto.getTotalCuentas());
        creditoHipotecarioEntityBuilder.lineaTotal(creditoHipotecarioDto.getLineaTotal());
        creditoHipotecarioEntityBuilder.saldoTotal(creditoHipotecarioDto.getSaldoTotal());
        return creditoHipotecarioEntityBuilder.build();
    }
    private LeyendaEntity leyendaDtoToEntity(LeyendaDto leyendaDto){
        LeyendaEntity.LeyendaEntityBuilder leyendaEntityBuilder = LeyendaEntity.builder();
        leyendaEntityBuilder.estatusCuenta(leyendaDto.getEstatusCuenta());
        leyendaEntityBuilder.codigosPago(leyendaDto.getCodigosPago());
        leyendaEntityBuilder.tiposConsulta(leyendaDto.getTiposConsulta());
        return leyendaEntityBuilder.build();
    }
    private InformacionContactoEntity informacionContactoDtoToEntity(InformacionContactoDto informacionContactoDto) {
        InformacionContactoEntity.InformacionContactoEntityBuilder informacionContactoEntityBuilder = InformacionContactoEntity.builder();
        informacionContactoEntityBuilder.telefonoAtencion(informacionContactoDto.getTelefonoAtencion());
        informacionContactoEntityBuilder.paginaWeb(informacionContactoDto.getPaginaWeb());
        informacionContactoEntityBuilder.email(informacionContactoDto.getEmail());
        informacionContactoEntityBuilder.horarioAtencion(informacionContactoDto.getHorarioAtencion());
        return informacionContactoEntityBuilder.build();
    }




}
