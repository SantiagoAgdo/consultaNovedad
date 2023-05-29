package com.mibanco.novedades.es.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name= "novedad_cdt_digital")
public class NovedadesEntity {

    @Id
    private String id;
    private String numeroDocumento;
    private String codigoNovedad;
    private String descripcionNovedad;
    private Date fechaNovedad;
}
