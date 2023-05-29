package com.mibanco.novedades.gprc;

import com.mibanco.novedades.es.GetNovedadByDocumentRequest;
import com.mibanco.novedades.es.NovedadResponse;
import com.mibanco.novedades.es.dao.entity.NovedadesEntity;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import com.mibanco.novedades.es.grpc.NovedadesGrpcController;
import com.mibanco.novedades.es.service.impl.NovedadesConsultaDocumentoImpl;
import com.mibanco.novedades.es.utils.ConsultaNovedadesMapperGrpc;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class NovedadesClienteCDTGrpcTest {

    @Mock
    private NovedadesConsultaDocumentoImpl novedadesConsultaDocumento;

    @Mock
    private ConsultaNovedadesMapperGrpc consultaNovedadesMapperGrpc;

    @InjectMocks
    private NovedadesGrpcController novedadesGrpcController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testCrearNovedad(){
//        GetNovedadByDocumentRequest requestMock = GetNovedadByDocumentRequest.newBuilder().build();
//        NovedadCDTDigitalType novedadCDTDigitalTypeMock = new NovedadCDTDigitalType();
//        NovedadResponse rptMock = NovedadResponse.newBuilder().setNovedadCDTDigital(requestMock).build();
//        StreamObserver<NovedadResponse> responseObsMock = Mockito.mock(StreamObserver.class);
//
//        Mockito.when(consultaNovedadesMapperGrpc.novedadGrpcToEntity(requestMock)).thenReturn(new NovedadesEntity());
//        Mockito.when(consultaNovedadesMapperGrpc.novedadGrpcToGrpc(novedadCDTDigitalTypeMock)).thenReturn(requestMock);
//        Mockito.when(novedadesConsultaDocumento.
//                consultarNovedadesPorNumeroDocumento(novedadCDTDigitalTypeMock.getNumeroDocumento()))
//                .thenReturn((List<NovedadCDTDigitalType>) novedadCDTDigitalTypeMock);
//
//        novedadesGrpcController.consultarNovedad(requestMock, responseObsMock);
//
//        Mockito.verify(responseObsMock, Mockito.times(1)).onNext(rptMock);
//        Mockito.verify(responseObsMock, Mockito.times(1)).onCompleted();
//    }

}
