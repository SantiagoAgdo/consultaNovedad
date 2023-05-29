package com.mibanco.novedades.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.novedades.es.gen.type.NovedadCDTDigitalType;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@QuarkusTest
public class NovedadesControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @Mock
    private ObjectMapper objectMapperMock;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultarNovedadTest() throws IOException{
        Mockito.when(objectMapperMock.readValue(ArgumentMatchers.any(byte[].class), ArgumentMatchers.any(Class.class)))
                .thenReturn(new NovedadCDTDigitalType());

        String json = new String(Files.readAllBytes(Paths.get("src/main/resources/es-NovedadesES-api.json")), StandardCharsets.UTF_8);
        NovedadCDTDigitalType novedadCDTDigitalType = objectMapper.readValue(json, NovedadCDTDigitalType.class);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(novedadCDTDigitalType)
                .when()
                .get("v1/es/novedadCDTDigital?numeroDocumento=7654")
                .then()
                .statusCode(200);
    }
}
