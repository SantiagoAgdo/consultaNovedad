package com.mibanco.novedades.es.gen.contract;

import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es/novedadCDTDigital")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-29T11:22:22.581434500-05:00[America/Bogota]")
public interface V1NovedadesESApi {

    @GET
    @Produces({ "application/json" })
    List<NovedadCDTDigitalType> v1EsNovedadCDTDigitalGet(@QueryParam("numeroDocumento")   String numeroDocumento);
}
