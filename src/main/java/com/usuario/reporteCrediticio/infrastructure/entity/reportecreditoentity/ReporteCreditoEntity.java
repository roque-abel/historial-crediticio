package com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity;

import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.*;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.informacioncliente.InformacionContactoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.resumentipocredito.InformacionPersonalEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reportecreditoentity.reporte.resumentipocredito.ResumenTipoCreditoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "reporte")
public class ReporteCreditoEntity {
    @Id
    private String id;
    private MetadataEntity metadata;
    private InformacionPersonalEntity informacionPersonal;
    private ResumenGeneralEntity resumenGeneral;
    private ScoreCrediticioEntity scoreCrediticio;
    private List<CuentaDetalladaEntity> cuentasDetalladas;
    private List<ConsultaRealizadaEntity> consultasRealizadas;
    private List<AlertaEntity>  alertas;
    private ResumenTipoCreditoEntity resumenPorTipoCredito;
    private LeyendaEntity leyendas;
    private InformacionContactoEntity informacionContacto;
    private Boolean estatus;
    private String producto;

    @CreatedDate
    @Field("fecha_creacion")
    private Date fechaCreacion;

    @LastModifiedDate
    @Field("fecha_actualizacion")
    private Date fechaActualizacion;
}
