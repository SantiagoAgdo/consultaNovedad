package com.mibanco.novedades.es.utils;

import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class NovedadesMapper {

    public NovedadCDTDigitalType novedadCDTDigitalToType(NovedadesEntity novedadesEntity){
        return new ModelMapper().map(novedadesEntity, NovedadCDTDigitalType.class);
    }


}
