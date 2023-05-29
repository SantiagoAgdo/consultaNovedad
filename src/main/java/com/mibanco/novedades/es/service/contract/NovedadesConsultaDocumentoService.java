package com.mibanco.novedades.es.service.contract;

import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;

import java.util.List;

public interface NovedadesConsultaDocumentoService {
    List<NovedadCDTDigitalType> consultarNovedadesPorNumeroDocumento(String numero);
}
