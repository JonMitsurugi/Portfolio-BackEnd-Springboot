
package com.portfolio.jma.service;

import com.portfolio.jma.model.Habilidad;
import com.portfolio.jma.repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService {
    @Autowired
    HabilidadRepository habilidadRepository;
    
    public List<Habilidad> list() {
        return habilidadRepository.findAll();
    }
            
    public Optional<Habilidad> getOne(int id) {
        return habilidadRepository.findById(id);
    }        
    
    public Optional<Habilidad> getByNombreHab(String nombreHab) {
        return habilidadRepository.findByNombreHab(nombreHab);
    }
    
    public void save(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }
    
    public void delete(int id) {
        habilidadRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return habilidadRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombreHab) {
        return habilidadRepository.existsByNombreHab(nombreHab);
    }
    
}
