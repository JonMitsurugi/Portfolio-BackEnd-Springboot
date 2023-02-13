package com.portfolio.jma.controller;

import com.portfolio.jma.service.IPersonaService;
import com.portfolio.jma.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin (maxAge = 3600, origins = "*")
@RestController
@RequestMapping ("personas")
public class Controller {
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("/ver")
    public List<Persona> verPersona() {
        return iPersonaService.verPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear") 
    public String crearPersona(@RequestBody Persona persona) {
        iPersonaService.crearPersona(persona); 
        return "La persona se ha creado exitosamente";
    } 
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/borrar/{id}")
    public String borrarPersona(@PathVariable Long id) {
        iPersonaService.borrarPersona(id);
        return "La persona se ha eliminado exitosamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/editar/{id}") 
    public Persona editarPersona(@PathVariable Long id, 
                               @RequestParam (name = "nombre") String nuevoNombre,
                               @RequestParam(name = "apellido") String nuevoApellido,
                               @RequestParam(name = "descripcion") String nuevoDescripcion, 
                               @RequestParam(name = "imgFondo") String nuevoImgFondo,
                               @RequestParam(name = "imgPerfil") String nuevoImgPerfil) {
        
        Persona persona = iPersonaService.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setDescripcion(nuevoDescripcion);
        persona.setImgFondo(nuevoImgFondo);
        persona.setImgPerfil(nuevoImgPerfil);
        
        iPersonaService.crearPersona(persona);
        return persona;
    }
    
    @GetMapping ("/traer")
    public Persona traerPersona() {
        Persona persona = iPersonaService.buscarPersona((long)1);
        return persona;
    }
    
    
}
    
    

