
package com.portfolio.jma.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadDto {
    
    @NotBlank
    private String nombreHab;
    @NotBlank
    private String urlImgHab;
    @NotBlank
    private String descripcionHab;
    @NotBlank
    private int progresoHab;
    
    public HabilidadDto() {
    }

    public HabilidadDto(String nombreHab, String urlImgHab, String descripcionHab, int progresoHab) {
        this.nombreHab = nombreHab;
        this.urlImgHab = urlImgHab;
        this.descripcionHab = descripcionHab;
        this.progresoHab = progresoHab;
    }
}
