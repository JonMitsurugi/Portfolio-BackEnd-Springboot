
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
public class Estudio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreEst;
    private String urlImgEst;
    @NotNull
    private int fechaInicioEst;
    private int fechaFinEst;
    @NotNull
    private String lugarEst;
    @NotNull
    @Column(name = "descripcion", length = 1000, nullable = false) 
    private String descripcionEst;

    
    public Estudio() {
    }

    public Estudio(String nombreEst, String urlImgEst, int fechaInicioEst, int fechaFinEst, String lugarEst, String descripcionEst) {
        this.nombreEst = nombreEst;
        this.urlImgEst = urlImgEst;
        this.fechaInicioEst = fechaInicioEst;
        this.fechaFinEst = fechaFinEst;
        this.lugarEst = lugarEst;
        this.descripcionEst = descripcionEst;
    }

   

   

}
