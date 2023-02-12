
package com.portfolio.jma.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstudioDto {
    
    @NotBlank
    private String nombreEst;
    private String urlImgEst;
    @NotBlank
    private int fechaInicioEst;
    private int fechaFinEst;
    @NotBlank
    private String lugarEst;
    @NotBlank
    private String descripcionEst;

    public EstudioDto() {
    }

    public EstudioDto(String nombreEst, String urlImgEst, int fechaInicioEst, int fechaFinEst, String lugarEst, String descripcionEst) {
        this.nombreEst = nombreEst;
        this.urlImgEst = urlImgEst;
        this.fechaInicioEst = fechaInicioEst;
        this.fechaFinEst = fechaFinEst;
        this.lugarEst = lugarEst;
        this.descripcionEst = descripcionEst;
    }

    

    
   

}
