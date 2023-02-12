
package com.portfolio.jma.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDto {
    
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String tipoPro;
    private String urlPro;
    @NotBlank
    private String descripcionPro;

    public ProyectoDto() {
    }

    public ProyectoDto(String nombrePro, String tipoPro, String urlPro, String descripcionPro) {
        this.nombrePro = nombrePro;
        this.tipoPro = tipoPro;
        this.urlPro = urlPro;
        this.descripcionPro = descripcionPro;
    }

   

     
}
