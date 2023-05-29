package com.mibanco.novedades.es.dao.contract;

import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface INovedadesConsultaDocumentoDao extends PanacheRepository<NovedadesEntity> {
}
