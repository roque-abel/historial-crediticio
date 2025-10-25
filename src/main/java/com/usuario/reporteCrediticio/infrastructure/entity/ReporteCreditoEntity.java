package com.usuario.reporteCrediticio.infrastructure.entity;

import com.usuario.reporteCrediticio.infrastructure.entity.reporte.*;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.informacioncliente.InformacionContactoEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.resumentipocredito.InformacionPersonalEntity;
import com.usuario.reporteCrediticio.infrastructure.entity.reporte.resumentipocredito.ResumenTipoCreditoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "reporte")
public class ReporteCreditoEntity {
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
}
