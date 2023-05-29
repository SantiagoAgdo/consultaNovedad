package com.mibanco.novedades.es.utils;

import com.mibanco.novedades.es.GetNovedadByDocumentRequest;
import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ConsultaNovedadesMapperGrpc {

    public NovedadesEntity novedadGrpcToEntity(GetNovedadByDocumentRequest consultaNovedadlGrpc){
        var retorno = new ModelMapper().map(consultaNovedadlGrpc, NovedadesEntity.class);
        System.out.println(" ================   respuesta del modelMapper" + retorno + " =============");
        return retorno;
    }

    public GetNovedadByDocumentRequest novedadGrpcToGrpc(NovedadCDTDigitalType novedadCDTDigitalType){
        return new ModelMapper().map(novedadCDTDigitalType, GetNovedadByDocumentRequest.class);
    }

}
