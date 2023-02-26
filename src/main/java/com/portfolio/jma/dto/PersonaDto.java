
package com.portfolio.jma.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class PersonaDto {
   
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String imgFondo;
 
    @NotBlank
    private String imgPerfil;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String descripcion, String imgFondo, String imgPerfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imgFondo = imgFondo;
        this.imgPerfil = imgPerfil;
    }
    
    
}
