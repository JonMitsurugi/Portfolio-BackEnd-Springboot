
package com.portfolio.jma.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    
    @NotBlank
    private String nombreExp;
    @NotBlank
    private int fechaInicioExp;
    private int fechaFinExp;
    @NotBlank
    private String rolExp;
    @NotBlank
    private String descripcionExp;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, int fechaInicioExp, int fechaFinExp, String rolExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.fechaInicioExp = fechaInicioExp;
        this.fechaFinExp = fechaFinExp;
        this.rolExp = rolExp;
        this.descripcionExp = descripcionExp;
    }

}
