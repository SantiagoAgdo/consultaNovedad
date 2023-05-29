package com.mibanco.novedades.es.graphql;

import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import com.mibanco.novedades.es.service.impl.NovedadesConsultaDocumentoImpl;
import com.mibanco.novedades.es.utils.ErrorCts;
import com.mibanco.novedades.es.utils.NovedadesException;
import com.mibanco.novedades.es.utils.NovedadesMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GraphQLApi
public class NovedadesGraphlController {

    public static final Logger logger = LoggerFactory.getLogger(NovedadesGraphlController.class);

    @Inject
    NovedadesConsultaDocumentoImpl novedadesConsultaDocumento;

    @Inject
    NovedadesMapper novedadesMapper;

    @Query("consultaNovedadPorNumeroDocumento")
    @Description("Consulta de novedades por numero de documento")
    public List<NovedadCDTDigitalType> getNovedadPorDocuemnto(@QueryParam("numeroDocumento") String numeroDocumento){

        logger.info("Inicia consulta novedad por numero de documento en Graphql");

        try {
            List<NovedadCDTDigitalType> novedad = novedadesConsultaDocumento.consultarNovedadesPorNumeroDocumento(numeroDocumento);
            logger.info("Termina consulta novedad por numero de documento en Graphql");
            return  novedad;
        }catch (NovedadesException e){
            logger.info("Ocurrio un error en getNovedadPorDocuemnto Graphql");
            throw new NovedadesException(ErrorCts.SERVICIO + " exception : " + e.getMessage() + " en GraphQl");
        }
    }

}
