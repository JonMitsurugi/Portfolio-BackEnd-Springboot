
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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreExp;
    @NotNull
    private int fechaInicioExp;
    private int fechaFinExp;
    @NotNull
    private String rolExp;
    @NotNull
    @Column(name = "descripcion", length = 1000, nullable = false) 
    private String descripcionExp;

    
    public Experiencia() {
    }

    public Experiencia(String nombreExp, int fechaInicioExp, int fechaFinExp, String rolExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.fechaInicioExp = fechaInicioExp;
        this.fechaFinExp = fechaFinExp;
        this.rolExp = rolExp;
        this.descripcionExp = descripcionExp;
    }

}
