
package com.portfolio.jma.dto;

import javax.validation.constraints.NotBlank;


public class ExperienciaDto {
    
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String fechaInicioExp;
    private String fechaFinExp;
    @NotBlank
    private String rolExp;
    @NotBlank
    private String descripcionExp;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, String fechaInicioExp, String fechaFinExp, String rolExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.fechaInicioExp = fechaInicioExp;
        this.fechaFinExp = fechaFinExp;
        this.rolExp = rolExp;
        this.descripcionExp = descripcionExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getFechaInicioExp() {
        return fechaInicioExp;
    }

    public void setFechaInicioExp(String fechaInicioExp) {
        this.fechaInicioExp = fechaInicioExp;
    }

    public String getFechaFinExp() {
        return fechaFinExp;
    }

    public void setFechaFinExp(String fechaFinExp) {
        this.fechaFinExp = fechaFinExp;
    }

    public String getRolExp() {
        return rolExp;
    }

    public void setRolExp(String rolExp) {
        this.rolExp = rolExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
   
    
    
}
