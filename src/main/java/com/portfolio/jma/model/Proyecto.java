
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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombrePro;
    @NotNull
    private String tipoPro;
    private String urlPro;
    @NotNull
    @Column(name = "descripcion", length = 1000, nullable = false) 
    private String descripcionPro;

    
    public Proyecto() {
    }

    public Proyecto(String nombrePro, String tipoPro, String urlPro, String descripcionPro) {
        this.nombrePro = nombrePro;
        this.tipoPro = tipoPro;
        this.urlPro = urlPro;
        this.descripcionPro = descripcionPro;
    }

   

    

}
