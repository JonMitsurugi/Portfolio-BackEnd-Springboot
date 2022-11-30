package com.portfolio.jma.service;

import com.portfolio.jma.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.jma.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    public PersonaRepository iPersonaRepository;
    
    
    @Override
    public List<Persona> verPersona() {
        List<Persona> personas = iPersonaRepository.findAll();
        return personas;
    }

    @Override
    public void crearPersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
