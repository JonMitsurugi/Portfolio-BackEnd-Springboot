
package com.portfolio.jma.service;

import com.portfolio.jma.model.Experiencia;
import com.portfolio.jma.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;
    
    public List<Experiencia> list() {
        return experienciaRepository.findAll();
    }
            
    public Optional<Experiencia> getOne(int id) {
        return experienciaRepository.findById(id);
    }        
    
    public Optional<Experiencia> getByNombreExp(String nombreExp) {
        return experienciaRepository.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }
    
    public void delete(int id) {
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return experienciaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombreExp) {
        return experienciaRepository.existsByNombreExp(nombreExp);
    }
    
}
