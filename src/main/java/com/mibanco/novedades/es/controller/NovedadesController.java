package com.mibanco.novedades.es.controller;

import com.mibanco.novedades.es.gen.contract.V1NovedadesESApi;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import com.mibanco.novedades.es.service.impl.NovedadesConsultaDocumentoImpl;
import com.mibanco.novedades.es.utils.ErrorCts;
import com.mibanco.novedades.es.utils.NovedadesException;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NovedadesController implements V1NovedadesESApi {

    public static final Logger logger = LoggerFactory.getLogger(NovedadesController.class);

    @Inject
    NovedadesConsultaDocumentoImpl novedadesConsultaDocumentoImpl;

    @Override
    public List<NovedadCDTDigitalType> v1EsNovedadCDTDigitalGet(String numeroDocumento) {
        logger.info("Inicia consultarNovedadesPorNumeroDocumentoController");

        try{
            List<NovedadCDTDigitalType> list = novedadesConsultaDocumentoImpl.consultarNovedadesPorNumeroDocumento(numeroDocumento);
            logger.info("Finaliza consultarNovedadesPorNumeroDocumentoController");
            return list;
        }catch (NovedadesException novedadesException){
            logger.error(ErrorCts.SERVICIO + " consultarNovedadesPorNumeroDocumentoController exception: " + novedadesException.getMessage());
            throw  new NovedadesException(ErrorCts.SERVICIO + novedadesException.getMessage() + " En consultarNovedadesPorNumeroDocumentoController");
        }
    }
}
