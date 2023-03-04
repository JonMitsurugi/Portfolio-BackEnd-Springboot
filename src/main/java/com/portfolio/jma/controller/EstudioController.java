
package com.portfolio.jma.controller;


import com.portfolio.jma.dto.EstudioDto;
import com.portfolio.jma.model.Estudio;
import com.portfolio.jma.security.controller.Mensaje;
import com.portfolio.jma.service.EstudioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudio")
@CrossOrigin(origins = "https://porfolio-frontend-jma.web.app")
public class EstudioController {
    
    @Autowired
    EstudioService estudioService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = estudioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id ) {
        if (!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el Id."), HttpStatus.BAD_REQUEST);
            
        }
    
        Estudio estudio = estudioService.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EstudioDto estudioDto) {
        if (StringUtils.isBlank(estudioDto.getNombreEst())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(estudioService.existsByNombre(estudioDto.getNombreEst())) {
            return new ResponseEntity(new Mensaje("La estudio ya existe"), HttpStatus.BAD_REQUEST);
        }
    Estudio estudio = new Estudio(estudioDto.getNombreEst(),estudioDto.getUrlImgEst(), estudioDto.getFechaInicioEst(), estudioDto.getFechaFinEst(), estudioDto.getLugarEst(), estudioDto.getDescripcionEst());
    estudioService.save(estudio);
    
    return  new ResponseEntity(new Mensaje("La estudio ha sido agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EstudioDto estudioDto) {
        if(!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."),HttpStatus.BAD_REQUEST);
        }
        if(estudioService.existsByNombre(estudioDto.getNombreEst()) && estudioService.getByNombreEst(estudioDto.getNombreEst()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa estudio ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(estudioDto.getNombreEst())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Estudio estudio = estudioService.getOne(id).get();
        estudio.setNombreEst(estudioDto.getNombreEst());
        estudio.setUrlImgEst(estudioDto.getUrlImgEst());
        estudio.setFechaInicioEst(estudioDto.getFechaInicioEst());
        estudio.setFechaFinEst(estudioDto.getFechaFinEst());
        estudio.setLugarEst(estudioDto.getLugarEst());
        estudio.setDescripcionEst(estudioDto.getDescripcionEst());
        
        estudioService.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."), HttpStatus.BAD_REQUEST);
        }
        
        estudioService.delete(id);
        
        return new ResponseEntity(new Mensaje("Estudio eliminado papa!!."), HttpStatus.OK);
    }
        
    
    
}
