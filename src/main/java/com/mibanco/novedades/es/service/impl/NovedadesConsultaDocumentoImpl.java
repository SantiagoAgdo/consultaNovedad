package com.mibanco.novedades.es.service.impl;

import com.mibanco.novedades.es.controller.NovedadesController;
import com.mibanco.novedades.es.dao.contract.NovedadConsultaDocumentoDao;
import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import com.mibanco.novedades.es.service.contract.NovedadesConsultaDocumentoService;
import com.mibanco.novedades.es.utils.ErrorCts;
import com.mibanco.novedades.es.utils.NovedadesException;
import com.mibanco.novedades.es.utils.NovedadesMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class NovedadesConsultaDocumentoImpl  implements NovedadesConsultaDocumentoService {

    public static final Logger logger = LoggerFactory.getLogger(NovedadesController.class);

    @Inject
    NovedadConsultaDocumentoDao novedadConsultaDocumentoDao;

    @Inject
    NovedadesMapper novedadesMapper;

    @Override
    public List<NovedadCDTDigitalType> consultarNovedadesPorNumeroDocumento(String numero) {
        logger.info("Inicia consulta de NovedadesPorNumeroDocumento");

        try {
            List<NovedadesEntity> list = novedadConsultaDocumentoDao.list("numeroDocumento", numero);

            logger.info("Termina consulta de NovedadesPorNumeroDocumento");
            return  list.stream().map(novedadesMapper::novedadCDTDigitalToType)
                    .collect(Collectors.toList());
        }catch (NovedadesException e){
            logger.error(ErrorCts.OUTPUT_CLIENTES + " en NovedadesConsultaDocumentoImpl exception: " + e.getMessage());
            throw new NovedadesException(ErrorCts.SERVICIO + e.getMessage() + "  en NovedadesConsultaDocumentoImpl ");
        }
    }
}
