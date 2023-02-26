package com.portfolio.jma.model;

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
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud.")
    private String apellido;
    @NotNull
    private String descripcion;
    
    @NotNull
    private String imgFondo;
 
    @NotNull
    private String imgPerfil;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcion, String imgFondo, String imgPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imgFondo = imgFondo;
        this.imgPerfil = imgPerfil;
    }
    
}
