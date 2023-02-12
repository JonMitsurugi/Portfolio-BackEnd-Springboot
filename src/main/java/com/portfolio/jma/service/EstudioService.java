
package com.portfolio.jma.service;

import com.portfolio.jma.model.Estudio;
import com.portfolio.jma.repository.EstudioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EstudioService {
    @Autowired
    EstudioRepository estudioRepository;
    
    public List<Estudio> list() {
        return estudioRepository.findAll();
    }
            
    public Optional<Estudio> getOne(int id) {
        return estudioRepository.findById(id);
    }        
    
    public Optional<Estudio> getByNombreEst(String nombreEst) {
        return estudioRepository.findByNombreEst(nombreEst);
    }
    
    public void save(Estudio estudio) {
        estudioRepository.save(estudio);
    }
    
    public void delete(int id) {
        estudioRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return estudioRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombreEst) {
        return estudioRepository.existsByNombreEst(nombreEst);
    }
    
}
