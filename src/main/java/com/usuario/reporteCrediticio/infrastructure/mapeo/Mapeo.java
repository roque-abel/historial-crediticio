package com.usuario.reporteCrediticio.infrastructure.mapeo;

import com.fasterxml.classmate.members.RawField;
import com.usuario.reporteCrediticio.Service.dto.CatVigenciaDto;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.EscalaDto;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.FactorClaveDto;
import com.usuario.reporteCrediticio.Service.dto.motordereglas.NivelRiesgoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.ReporteCreditoDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.DireccionDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.IdentificacionDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.InformacionPersonalDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.clienteDto.NombreDto;
import com.usuario.reporteCrediticio.Service.dto.reportecrediticio.reporteDto.*;
import com.usuario.reporteCrediticio.infrastructure.entity.CatVigenciaEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.Escala;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.FactorClave;
import com.usuario.reporteCrediticio.infrastructure.entity.nivelriegoentity.NivelRiesgoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.ReporteCreditoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.*;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.DireccionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.IdentificacionEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.InformacionContactoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.NombreEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.resumentipocredito.*;
import org.springframework.stereotype.Component;

import javax.lang.model.type.IntersectionType;
import java.security.PrivateKey;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
        reporteCreditoEntityBuilder.estatus(reporteCreditoDto.getEstatus());
        reporteCreditoEntityBuilder.producto(reporteCreditoDto.getProducto());

        return reporteCreditoEntityBuilder.build();

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

    private MetadataEntity metadataDtoToEntity(MetadataDto metadataDto) {

        MetadataEntity.MetadataEntityBuilder metadataBuilderEntity = MetadataEntity.builder();
        metadataBuilderEntity.numeroReporte(metadataDto.getNumeroReporte());
        metadataBuilderEntity.tipoReporte(metadataDto.getTipoReporte());
        metadataBuilderEntity.fechaEmision(metadataDto.getFechaEmision());
        metadataBuilderEntity.version(metadataDto.getVersion());
        return metadataBuilderEntity.build();
    }

    private InformacionPersonalEntity informacionPersonalDtoToEntity(InformacionPersonalDto informacionPersonalDto) {

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

    private DireccionEntity direccionDtoToEntity(DireccionDto direccionDto) {
        DireccionEntity.DireccionEntityBuilder direccionBuilderEntity = DireccionEntity.builder();
        direccionBuilderEntity.calle(direccionDto.getCalle());
        direccionBuilderEntity.numeroExterior(direccionDto.getNumeroExterior());
        direccionBuilderEntity.colonia(direccionDto.getColonia());
        direccionBuilderEntity.ciudad(direccionDto.getCiudad());
        direccionBuilderEntity.codigoPostal(direccionDto.getCodigoPostal());
        direccionBuilderEntity.estado(direccionDto.getEstado());
        return direccionBuilderEntity.build();
    }

    private IdentificacionEntity identificacionDtoToEntity(IdentificacionDto identificacionDto) {
        IdentificacionEntity.IdentificacionEntityBuilder identificacionBuilderEntity = IdentificacionEntity.builder();
        identificacionBuilderEntity.rfc(identificacionDto.getRfc());
        identificacionBuilderEntity.curp(identificacionDto.getCurp());
        identificacionBuilderEntity.fechaNacimiento(identificacionDto.getFechaNacimiento());
        return identificacionBuilderEntity.build();
    }

    private NombreEntity nombreDtoToEntity(NombreDto nombreDto) {
        NombreEntity.NombreEntityBuilder nombreEntityBuilder = NombreEntity.builder();
        nombreEntityBuilder.nombre(nombreDto.getNombre());
        nombreEntityBuilder.apellidoMaterno(nombreDto.getApellidoMaterno());
        nombreEntityBuilder.apellidoPaterno(nombreDto.getApellidoPaterno());
        return nombreEntityBuilder.build();

    }

    private ResumenGeneralEntity resumenGeneralDtoToEntity(ResumenGeneralDto resumenGeneralDto) {
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

    private ScoreCrediticioEntity scoreCrediticioDtoToEntity(ScoreCrediticioDto scoreCrediticioDto) {
        ScoreCrediticioEntity.ScoreCrediticioEntityBuilder scoreCrediticioEntityBuilder = ScoreCrediticioEntity.builder();
        scoreCrediticioEntityBuilder.puntaje(scoreCrediticioDto.getPuntaje());
        scoreCrediticioEntityBuilder.escala(scoreCrediticioDto.getEscala());
        scoreCrediticioEntityBuilder.percentil(scoreCrediticioDto.getPercentil());
        scoreCrediticioEntityBuilder.interpretacion(scoreCrediticioDto.getInterpretacion());
        scoreCrediticioEntityBuilder.factoresInfluencia(scoreCrediticioDto.getFactoresInfluencia());
        return scoreCrediticioEntityBuilder.build();
    }

    private ResumenTipoCreditoEntity resumenTipoCreditoDtoToEntity(ResumenTipoCreditoDto resumenTipoCreditoDto) {
        TarjetaCreditoEntity tarjetaCreditoEntity = this.tarjetaCreditoDtoToEntity(resumenTipoCreditoDto.getTarjetaCredito());
        CreditoAutomotrizEntity creditoAutomotrizEntity = this.creditoAutomotrizDtoToEntity(resumenTipoCreditoDto.getCreditoAutomotriz());
        CreditoHipotecarioEntity creditoHipotecarioEntity = this.creditoHipotecarioDtoToEntity(resumenTipoCreditoDto.getCreditoHipotecario());

        ResumenTipoCreditoEntity.ResumenTipoCreditoEntityBuilder resumenTipoCreditoEntityBuilder = ResumenTipoCreditoEntity.builder();
        resumenTipoCreditoEntityBuilder.tarjetaCredito(tarjetaCreditoEntity);
        resumenTipoCreditoEntityBuilder.creditoAutomotriz(creditoAutomotrizEntity);
        resumenTipoCreditoEntityBuilder.creditoHipotecario(creditoHipotecarioEntity);
        return resumenTipoCreditoEntityBuilder.build();

    }

    private TarjetaCreditoEntity tarjetaCreditoDtoToEntity(TarjetaCreditoDto tarjetaCreditoDto) {
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

    private CreditoAutomotrizEntity creditoAutomotrizDtoToEntity(CreditoAutomotrizDto creditoAutomotrizDto) {
        CreditoAutomotrizEntity.CreditoAutomotrizEntityBuilder creditoAutomotrizEntityBuilder = CreditoAutomotrizEntity.builder();
        creditoAutomotrizEntityBuilder.totalCuentas(creditoAutomotrizDto.getTotalCuentas());
        creditoAutomotrizEntityBuilder.cuentasVigentes(creditoAutomotrizDto.getCuentasVigentes());
        creditoAutomotrizEntityBuilder.lineaTotal(creditoAutomotrizDto.getLineaTotal());
        creditoAutomotrizEntityBuilder.saldoTotal(creditoAutomotrizDto.getSaldoTotal());
        creditoAutomotrizEntityBuilder.usoPorcentaje(creditoAutomotrizDto.getUsoPorcentaje());
        return creditoAutomotrizEntityBuilder.build();
    }

    private CreditoHipotecarioEntity creditoHipotecarioDtoToEntity(CreditoHipotecarioDto creditoHipotecarioDto) {
        CreditoHipotecarioEntity.CreditoHipotecarioEntityBuilder creditoHipotecarioEntityBuilder = CreditoHipotecarioEntity.builder();
        creditoHipotecarioEntityBuilder.totalCuentas(creditoHipotecarioDto.getTotalCuentas());
        creditoHipotecarioEntityBuilder.lineaTotal(creditoHipotecarioDto.getLineaTotal());
        creditoHipotecarioEntityBuilder.saldoTotal(creditoHipotecarioDto.getSaldoTotal());
        return creditoHipotecarioEntityBuilder.build();
    }

    private LeyendaEntity leyendaDtoToEntity(LeyendaDto leyendaDto) {
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

    public NivelRiesgoEntity nivelRiesgoDtoToEntity(NivelRiesgoDto nivelRiesgoDto) {


        Escala esc = this.escalaDtoToEntity(nivelRiesgoDto.getEscala());
        FactorClave factorC = this.factorClaveDtoToEntity(nivelRiesgoDto.getFactorClave());


        return NivelRiesgoEntity.builder()

                .id(nivelRiesgoDto.getId())
                .estatus(nivelRiesgoDto.getEstatus())
                .nivel(nivelRiesgoDto.getNivel())
                .descripcion(nivelRiesgoDto.getDescripcion())
                .puntajeInterno(nivelRiesgoDto.getPuntajeInterno())
                .escala(esc)
                .categoria(nivelRiesgoDto.getCategoria())
                .esApto(nivelRiesgoDto.getEsApto())
                .probabilidadAprobacion(nivelRiesgoDto.getProbabilidadAprobacion())
                .recomendacion(nivelRiesgoDto.getRecomendacion())
                .factorClave(factorC)
                .evaluadoPor(nivelRiesgoDto.getEvaluadoPor())
                .fechaEvaluacion(nivelRiesgoDto.getFechaEvaluacion())
                .build();

    }

    private Escala escalaDtoToEntity(EscalaDto escalaDto) {
        return Escala.builder()
                .minimo(escalaDto.getMinimo())
                .maximo(escalaDto.getMaximo())
                .build();
    }

    private FactorClave factorClaveDtoToEntity(FactorClaveDto factorClaveDto) {
        return FactorClave.builder()
                .usoCredito(factorClaveDto.getUsoCredito())
                .historialPagos(factorClaveDto.getHistorialPagos())
                .ingresosEstimados(factorClaveDto.getIngresosEstimados())
                .deudaTotal(factorClaveDto.getDeudaTotal())
                .porcentajeDeudaSobreIngreso(factorClaveDto.getPorcentajeDeudaSobreIngreso())
                .consultasRecientes(factorClaveDto.getConsultasRecientes())
                .build();
    }

    public ReporteCreditoDto reporteCreditoEnyotyToDto(ReporteCreditoEntity reporteCreditoEntity) {

        MetadataDto metadataDto = this.metadataEntityToDto(reporteCreditoEntity.getMetadata());
        InformacionPersonalDto infoPersonDto = this.informacionPersonalEntityToDto(reporteCreditoEntity.getInformacionPersonal());
        ResumenGeneralDto resumenGeneralDto = this.resumenGeneralEntityToDto(reporteCreditoEntity.getResumenGeneral());
        ScoreCrediticioDto scoreCrediticioDto = this.scoreCrediticioEntityToDto(reporteCreditoEntity.getScoreCrediticio());
        List<CuentaDetalladaDto> cuentasDetalladasDto = this.cuentaDetalladaEntityToDto(reporteCreditoEntity.getCuentasDetalladas());
        List<ConsultaRealizadaDto> consultasRealizadasDto = this.consultaRealizadaEntityToDto(reporteCreditoEntity.getConsultasRealizadas());
        List<AlertaDto> alertasDto = this.alertaEntityToDto(reporteCreditoEntity.getAlertas());
        ResumenTipoCreditoDto resumenTipoCreditoDto = this.resumenTipoCreditoEntityToDto(reporteCreditoEntity.getResumenPorTipoCredito());
        LeyendaDto leyendaDto = this.leyendaEntityToDto(reporteCreditoEntity.getLeyendas());
        InformacionContactoDto informacionContactoDto = this.informacionContactoEntityToDto(reporteCreditoEntity.getInformacionContacto());

        return ReporteCreditoDto.builder()
                .metadata(metadataDto)
                .informacionPersonal(infoPersonDto)
                .resumenGeneral(resumenGeneralDto)
                .scoreCrediticio(scoreCrediticioDto)
                .cuentasDetalladas(cuentasDetalladasDto)
                .consultasRealizadas(consultasRealizadasDto)
                .alertas(alertasDto)
                .resumenPorTipoCredito(resumenTipoCreditoDto)
                .leyendas(leyendaDto)
                .informacionContacto(informacionContactoDto)
                .fechaCreacion(reporteCreditoEntity.getFechaCreacion())
                .fechaActualizacion(reporteCreditoEntity.getFechaActualizacion())
                .idReporte(reporteCreditoEntity.getId())
                .build();
    }

    private MetadataDto metadataEntityToDto(MetadataEntity metadata) {
        return MetadataDto.builder()
                .numeroReporte(metadata.getNumeroReporte())
                .fechaEmision(metadata.getFechaEmision())
                .tipoReporte(metadata.getTipoReporte())
                .version(metadata.getVersion())
                .build();
    }

    private InformacionPersonalDto informacionPersonalEntityToDto(InformacionPersonalEntity infoPer) {
        NombreDto nombreDto = nombreEntityToDto(infoPer.getNombre());
        DireccionDto direccionDto = this.direccionEntityToDto(infoPer.getDireccion());
        IdentificacionDto identificacion = this.identificacionEntityToDto(infoPer.getIdentificacion());
        return InformacionPersonalDto.builder()
                .id(infoPer.getId())
                .nombre(nombreDto)
                .direccion(direccionDto)
                .identificacion(identificacion)
                .build();
    }

    private NombreDto nombreEntityToDto(NombreEntity nombreEntity) {
        return NombreDto.builder()
                .apellidoPaterno(nombreEntity.getApellidoPaterno())
                .apellidoMaterno(nombreEntity.getApellidoMaterno())
                .nombre(nombreEntity.getNombre())
                .build();
    }

    private DireccionDto direccionEntityToDto(DireccionEntity direccionEntity) {
        return DireccionDto.builder()
                .calle(direccionEntity.getCalle())
                .numeroExterior(direccionEntity.getNumeroExterior())
                .colonia(direccionEntity.getColonia())
                .codigoPostal(direccionEntity.getCodigoPostal())
                .ciudad(direccionEntity.getCiudad())
                .estado(direccionEntity.getEstado())
                .build();

    }

    private IdentificacionDto identificacionEntityToDto(IdentificacionEntity identificacion) {
        return IdentificacionDto.builder()
                .rfc(identificacion.getRfc())
                .curp(identificacion.getCurp())
                .fechaNacimiento(identificacion.getFechaNacimiento())
                .build();
    }

    private ScoreCrediticioDto scoreCrediticioEntityToDto(ScoreCrediticioEntity scoreCrediticio) {
        return ScoreCrediticioDto.builder()
                .puntaje(scoreCrediticio.getPuntaje())
                .escala(scoreCrediticio.getEscala())
                .percentil(scoreCrediticio.getPercentil())
                .interpretacion(scoreCrediticio.getInterpretacion())
                .factoresInfluencia(scoreCrediticio.getFactoresInfluencia())
                .build();
    }


    private ResumenGeneralDto resumenGeneralEntityToDto(ResumenGeneralEntity resumenGeneral) {
        return ResumenGeneralDto.builder()
                .totalCreditos(resumenGeneral.getTotalCreditos())
                .creditosVigentes(resumenGeneral.getCreditosVigentes())
                .creditosCerrados(resumenGeneral.getCreditosCerrados())
                .creditosEnMora(resumenGeneral.getCreditosEnMora())
                .lineaCreditoTotal(resumenGeneral.getLineaCreditoTotal())
                .saldoTotalActual(resumenGeneral.getSaldoTotalActual())
                .pagoMensualTotal(resumenGeneral.getPagoMensualTotal())
                .porcentajeEndeudamiento(resumenGeneral.getPorcentajeEndeudamiento())
                .build();
    }

    private List<CuentaDetalladaDto> cuentaDetalladaEntityToDto(List<CuentaDetalladaEntity> cuentasDetalladas) {
        return cuentasDetalladas.stream()
                .map(cuenta -> {
                    return CuentaDetalladaDto.builder()
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
                            .build();
                }).collect(Collectors.toList());
    }

    private List<ConsultaRealizadaDto> consultaRealizadaEntityToDto(List<ConsultaRealizadaEntity> consultas) {
        return consultas.stream()
                .map(consulta -> {
                    return ConsultaRealizadaDto.builder()
                            .fecha(consulta.getFecha())
                            .institucion(consulta.getInstitucion())
                            .tipoConsulta(consulta.getTipoConsulta())
                            .motivo(consulta.getMotivo())
                            .build();
                }).collect(Collectors.toList());
    }

    private List<AlertaDto> alertaEntityToDto(List<AlertaEntity> alertas) {
        return alertas.stream()
                .map(alerta -> {
                    return AlertaDto.builder()
                            .tipo(alerta.getTipo())
                            .descripcion(alerta.getDescripcion())
                            .nivel(alerta.getNivel())
                            .fechaGeneracion(alerta.getFechaGeneracion())
                            .build();
                }).collect(Collectors.toList());
    }

    private ResumenTipoCreditoDto resumenTipoCreditoEntityToDto(ResumenTipoCreditoEntity resumenTipoCreditoEntity) {
        TarjetaCreditoDto tarjetaCreditoDto = this.tarjetaCreditoEntityToDto(resumenTipoCreditoEntity.getTarjetaCredito());
        CreditoAutomotrizDto creditoAutomotrizDto = this.creditoAutomotrizEntityToDto(resumenTipoCreditoEntity.getCreditoAutomotriz());
        CreditoHipotecarioDto creditoHipotecarioDto = this.creditoHipotecarioEntityToDto(resumenTipoCreditoEntity.getCreditoHipotecario());

        return ResumenTipoCreditoDto.builder()
                .tarjetaCredito(tarjetaCreditoDto)
                .creditoAutomotriz(creditoAutomotrizDto)
                .creditoHipotecario(creditoHipotecarioDto)
                .build();
    }

    private TarjetaCreditoDto tarjetaCreditoEntityToDto(TarjetaCreditoEntity tarjetaCredito) {
        return TarjetaCreditoDto.builder()
                .totalCuentas(tarjetaCredito.getTotalCuentas())
                .cuentasVigentes(tarjetaCredito.getCuentasVigentes())
                .cuentasCerradas(tarjetaCredito.getCuentasCerradas())
                .cuentasEnMora(tarjetaCredito.getCuentasEnMora())
                .lineaTotal(tarjetaCredito.getLineaTotal())
                .saldoTotal(tarjetaCredito.getSaldoTotal())
                .usoPorcentaje(tarjetaCredito.getUsoPorcentaje())
                .build();
    }

    private CreditoAutomotrizDto creditoAutomotrizEntityToDto(CreditoAutomotrizEntity creditoAutomotriz) {
        return CreditoAutomotrizDto.builder()
                .totalCuentas(creditoAutomotriz.getTotalCuentas())
                .cuentasVigentes(creditoAutomotriz.getCuentasVigentes())
                .lineaTotal(creditoAutomotriz.getLineaTotal())
                .saldoTotal(creditoAutomotriz.getSaldoTotal())
                .usoPorcentaje(creditoAutomotriz.getUsoPorcentaje())
                .build();
    }

    private CreditoHipotecarioDto creditoHipotecarioEntityToDto(CreditoHipotecarioEntity hipotecarioEntity) {
        return CreditoHipotecarioDto.builder()
                .totalCuentas(hipotecarioEntity.getTotalCuentas())
                .lineaTotal(hipotecarioEntity.getLineaTotal())
                .saldoTotal(hipotecarioEntity.getSaldoTotal())
                .build();
    }

    private LeyendaDto leyendaEntityToDto(LeyendaEntity leyendaEntity) {
        return LeyendaDto.builder()
                .estatusCuenta(leyendaEntity.getEstatusCuenta())
                .codigosPago(leyendaEntity.getCodigosPago())
                .tiposConsulta(leyendaEntity.getTiposConsulta())
                .build();
    }

    private InformacionContactoDto informacionContactoEntityToDto(InformacionContactoEntity informacionContacto) {
        return InformacionContactoDto.builder()
                .telefonoAtencion(informacionContacto.getTelefonoAtencion())
                .paginaWeb(informacionContacto.getPaginaWeb())
                .email(informacionContacto.getEmail())
                .horarioAtencion(informacionContacto.getHorarioAtencion())
                .build();
    }


    public NivelRiesgoDto nivelRiesgoEntityToDto(NivelRiesgoEntity nivelRiesgoEntity) {

        FactorClaveDto factorClaveDto = this.FactorClaveEntityToDto(nivelRiesgoEntity.getFactorClave());
        EscalaDto escalaDto = this.escalaEntityToDto(nivelRiesgoEntity.getEscala());
        return NivelRiesgoDto.builder()
                .id(nivelRiesgoEntity.getId())
                .estatus(nivelRiesgoEntity.getEstatus())
                .nivel(nivelRiesgoEntity.getNivel())
                .descripcion(nivelRiesgoEntity.getDescripcion())
                .puntajeInterno(nivelRiesgoEntity.getPuntajeInterno())
                .escala(escalaDto)
                .categoria(nivelRiesgoEntity.getCategoria())
                .esApto(nivelRiesgoEntity.getEsApto())
                .probabilidadAprobacion(nivelRiesgoEntity.getProbabilidadAprobacion())
                .recomendacion(nivelRiesgoEntity.getRecomendacion())
                .factorClave(factorClaveDto)
                .evaluadoPor(nivelRiesgoEntity.getEvaluadoPor())
                .fechaEvaluacion(nivelRiesgoEntity.getFechaEvaluacion())
                .build();

    }

    private EscalaDto escalaEntityToDto(Escala escala) {
        return EscalaDto.builder()
                .maximo(escala.getMaximo())
                .minimo(escala.getMinimo())
                .build();
    }

    private FactorClaveDto FactorClaveEntityToDto(FactorClave factorClave) {
        return FactorClaveDto.builder()
                .usoCredito(factorClave.getUsoCredito())
                .historialPagos(factorClave.getHistorialPagos())
                .ingresosEstimados(factorClave.getIngresosEstimados())
                .deudaTotal(factorClave.getDeudaTotal())
                .porcentajeDeudaSobreIngreso(factorClave.getPorcentajeDeudaSobreIngreso())
                .consultasRecientes(factorClave.getConsultasRecientes())
                .build();
    }

    public CatVigenciaDto catVigenciaEntity(CatVigenciaEntity catVigenciaEntity){
        return CatVigenciaDto.builder()
                .diasVigencia(catVigenciaEntity.getDiasVigencia())
                .producto(catVigenciaEntity.getProducto())
                .build();
    }

    public CatVigenciaEntity catVigenciaDtoToEntity(String idProducto){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(30);
        return CatVigenciaEntity.builder()
                .producto(idProducto)
                .diasVigencia(numeroAleatorio)
                .build();
    }

}
