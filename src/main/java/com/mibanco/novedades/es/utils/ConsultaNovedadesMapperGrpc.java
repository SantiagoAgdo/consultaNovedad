package com.mibanco.novedades.es.utils;

import com.mibanco.novedades.es.ConsultaNovedadlGrpc;
import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ConsultaNovedadesMapperGrpc {

    public NovedadesEntity novedadGrpcToEntity(ConsultaNovedadlGrpc consultaNovedadlGrpc){
        var retorno = new ModelMapper().map(consultaNovedadlGrpc, NovedadesEntity.class);
        System.out.println(" ================   respuesta del modelMapper" + retorno + " =============");
        return retorno;
    }

    public ConsultaNovedadlGrpc novedadGrpcToGrpc(NovedadCDTDigitalType novedadCDTDigitalType){
        return new ModelMapper().map(novedadCDTDigitalType, ConsultaNovedadlGrpc.class);
    }

}
