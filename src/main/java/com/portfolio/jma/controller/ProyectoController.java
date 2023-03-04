
package com.portfolio.jma.controller;


import com.portfolio.jma.dto.ProyectoDto;
import com.portfolio.jma.model.Proyecto;
import com.portfolio.jma.security.controller.Mensaje;
import com.portfolio.jma.service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://porfolio-frontend-jma.web.app")
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id ) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el Id."), HttpStatus.BAD_REQUEST);
            
        }
    
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto) {
        if (StringUtils.isBlank(proyectoDto.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existsByNombre(proyectoDto.getNombrePro())) {
            return new ResponseEntity(new Mensaje("La proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
    Proyecto proyecto = new Proyecto(proyectoDto.getNombrePro(), proyectoDto.getTipoPro(), proyectoDto.getUrlPro(),proyectoDto.getDescripcionPro());
    proyectoService.save(proyecto);
    
    return  new ResponseEntity(new Mensaje("La proyecto ha sido agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto) {
        if(!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."),HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existsByNombre(proyectoDto.getNombrePro()) && proyectoService.getByNombrePro(proyectoDto.getNombrePro()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectoDto.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombrePro(proyectoDto.getNombrePro());
        proyecto.setTipoPro(proyectoDto.getTipoPro());
        proyecto.setUrlPro(proyectoDto.getUrlPro());
        proyecto.setDescripcionPro(proyectoDto.getDescripcionPro());
        
        
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe."), HttpStatus.BAD_REQUEST);
        }
        
        proyectoService.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminada papa!!."), HttpStatus.OK);
    }
        
    
    
}
