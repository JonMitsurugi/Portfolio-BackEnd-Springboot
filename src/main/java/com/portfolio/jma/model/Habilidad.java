
package com.portfolio.jma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreHab;
    @NotNull
    private String urlImgHab;
    @NotNull
    private String descripcionHab;
    @NotNull
    private int progresoHab;

    public Habilidad() {
    }
     
    public Habilidad(String nombreHab, String urlImgHab, String descripcionHab, int progresoHab) {
        this.nombreHab = nombreHab;
        this.urlImgHab = urlImgHab;
        this.descripcionHab = descripcionHab;
        this.progresoHab = progresoHab;
    }

}
