
package com.portfolio.jma.controller;


import com.portfolio.jma.dto.ExperienciaDto;
import com.portfolio.jma.model.Experiencia;
import com.portfolio.jma.security.controller.Mensaje;
import com.portfolio.jma.service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existsByNombre(experienciaDto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
    Experiencia experiencia = new Experiencia(experienciaDto.getNombreExp(), experienciaDto.getFechaInicioExp(), experienciaDto.getFechaFinExp(), experienciaDto.getRolExp(), experienciaDto.getDescripcionExp());
    experienciaService.save(experiencia);
    
    return  new ResponseEntity(new Mensaje("La experiencia ha sido agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto) {
        if(!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."),HttpStatus.BAD_REQUEST);
        }
        if(experienciaService.existsByNombre(experienciaDto.getNombreExp()) && experienciaService.getByNombreExp(experienciaDto.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreExp(experienciaDto.getNombreExp());
        experiencia.setFechaInicioExp(experienciaDto.getFechaInicioExp());
        experiencia.setFechaFinExp(experienciaDto.getFechaFinExp());
        experiencia.setRolExp(experienciaDto.getRolExp());
        experiencia.setDescripcionExp(experienciaDto.getDescripcionExp());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."), HttpStatus.BAD_REQUEST);
        }
        
        experienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada."), HttpStatus.OK);
    }
        
    
    
}
