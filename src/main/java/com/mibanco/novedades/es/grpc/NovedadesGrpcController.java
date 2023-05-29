package com.mibanco.novedades.es.grpc;

import com.mibanco.novedades.es.ConsultaNovedadGrpcGrpc;
import com.mibanco.novedades.es.GetNovedadByDocumentRequest;
import com.mibanco.novedades.es.NovedadResponse;
import com.mibanco.novedades.es.controller.NovedadesController;
import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import com.mibanco.novedades.es.service.impl.NovedadesConsultaDocumentoImpl;
import com.mibanco.novedades.es.utils.ConsultaNovedadesMapperGrpc;
import com.mibanco.novedades.es.utils.ErrorCts;
import com.mibanco.novedades.es.utils.NovedadesException;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GrpcService
public class NovedadesGrpcController extends ConsultaNovedadGrpcGrpc.ConsultaNovedadGrpcImplBase {

    public static final Logger logger = LoggerFactory.getLogger(NovedadesController.class);

    @Inject
    NovedadesConsultaDocumentoImpl novedadesConsultaDocumentoImpl;

    @Inject
    ConsultaNovedadesMapperGrpc consultaNovedadesMapperGrpc;

    @Override
    @Blocking
    public void consultarNovedad(GetNovedadByDocumentRequest request, StreamObserver<NovedadResponse> responseObs){

        logger.info("Inicia Consulta Novedad por numero de documento mediante GRPC");

        NovedadesEntity novedadesEntity = consultaNovedadesMapperGrpc.novedadGrpcToEntity(request);

        try{
            List<NovedadCDTDigitalType> novedadCDTDigitalType =
                    novedadesConsultaDocumentoImpl.consultarNovedadesPorNumeroDocumento(novedadesEntity.getNumeroDocumento());

            NovedadResponse consultaNovedadEntidad =
                    NovedadResponse.newBuilder().setNovedadCDTDigital(consultaNovedadesMapperGrpc.novedadGrpcToGrpc(novedadCDTDigitalType.get(0))).build();

            responseObs.onNext(consultaNovedadEntidad);

            logger.info("Finaliza consulta novedad con GRPC");
            responseObs.onCompleted();
        }catch (NovedadesException e){
            logger.error(ErrorCts.SERVICIO + " Consulta Novedad Grpc");
            throw  new NovedadesException(ErrorCts.SERVICIO + e.getMessage() + " consuñta Novedad Grpc");
        }
    }

}
