package com.portfolio.jma.controller;

import com.portfolio.jma.service.IPersonaService;
import com.portfolio.jma.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("personas/ver")
    public List<Persona> verPersona() {
        return iPersonaService.verPersona();
    }
    
    @PostMapping("/personas/crear") 
    public String crearPersona(@RequestBody Persona persona) {
        iPersonaService.crearPersona(persona);
        return "La persona se ha creado exitosamente";
    } 
    
    @DeleteMapping ("personas/borrar/{id}")
    public String borrarPersona(@PathVariable Long id) {
        iPersonaService.borrarPersona(id);
        return "La persona se ha eliminado exitosamente";
    }

    @PutMapping ("/editar/{id}") 
    public Persona editarPersona(@PathVariable Long id, 
                               @RequestParam (name = "nombre") String nuevoNombre,
                               @RequestParam(name = "apellido") String nuevoApellido,
                               @RequestParam(name = "img") String nuevoImg) {
        
        Persona persona = iPersonaService.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        iPersonaService.crearPersona(persona);
        return persona;
    }
    
    @GetMapping ("/traer")
    public Persona traerPersona() {
        Persona persona = iPersonaService.buscarPersona((long) 6);
        return persona;
    }
    
    
}
    
    

