
package com.portfolio.jma.controller;


import com.portfolio.jma.dto.HabilidadDto;
import com.portfolio.jma.model.Habilidad;
import com.portfolio.jma.security.controller.Mensaje;
import com.portfolio.jma.service.HabilidadService;
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
@RequestMapping("habilidad")
@CrossOrigin(origins = "*")
public class HabilidadController {
    
    @Autowired
    HabilidadService habilidadService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = habilidadService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id ) {
        if (!habilidadService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el Id."), HttpStatus.BAD_REQUEST);
            
        }
    
        Habilidad habilidad = habilidadService.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody HabilidadDto habilidadDto) {
        if (StringUtils.isBlank(habilidadDto.getNombreHab())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(habilidadService.existsByNombre(habilidadDto.getNombreHab())) {
            return new ResponseEntity(new Mensaje("La habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
    Habilidad habilidad = new Habilidad(habilidadDto.getNombreHab(),habilidadDto.getUrlImgHab(), habilidadDto.getDescripcionHab(), habilidadDto.getProgresoHab());
    habilidadService.save(habilidad);
    
    return  new ResponseEntity(new Mensaje("La habilidad ha sido agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadDto habilidadDto) {
        if(!habilidadService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."),HttpStatus.BAD_REQUEST);
        }
        if(habilidadService.existsByNombre(habilidadDto.getNombreHab()) && habilidadService.getByNombreHab(habilidadDto.getNombreHab()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(habilidadDto.getNombreHab())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidad habilidad = habilidadService.getOne(id).get();
        habilidad.setNombreHab(habilidadDto.getNombreHab());
        habilidad.setUrlImgHab(habilidadDto.getUrlImgHab());
        habilidad.setDescripcionHab(habilidadDto.getDescripcionHab());
        habilidad.setProgresoHab(habilidadDto.getProgresoHab());
        
        
        habilidadService.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!habilidadService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."), HttpStatus.BAD_REQUEST);
        }
        
        habilidadService.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminado papa!!."), HttpStatus.OK);
    }
        
    
    
}
