package com.usuario.reporteCrediticio.infrastructure.entity.reporte.resumentipocredito;

import com.usuario.reporteCrediticio.Service.dto.reporteDto.CreditoAutomotrizDto;
import com.usuario.reporteCrediticio.Service.dto.reporteDto.CreditoHipotecarioDto;
import com.usuario.reporteCrediticio.Service.dto.reporteDto.TarjetaCreditoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumenTipoCreditoEntity {
    private TarjetaCreditoEntity tarjetaCredito;
    private CreditoAutomotrizEntity creditoAutomotriz;
    private CreditoHipotecarioEntity creditoHipotecario;
}
