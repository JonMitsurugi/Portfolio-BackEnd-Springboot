
package com.portfolio.jma.service;

import com.portfolio.jma.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    //Traer lista de Persona
    public List<Persona> verPersona();
    
    //Guardar una Persona
    public void crearPersona(Persona persona);
    
    //Eliminar una Persona a  través de Id
    public void borrarPersona(Long id);
    
    //Buscar Persona por Id;
    public Persona buscarPersona(Long id);
}
