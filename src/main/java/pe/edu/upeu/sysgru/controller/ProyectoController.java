package pe.edu.upeu.sysgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Curso;
import pe.edu.upeu.sysgru.entity.Proyecto;
import pe.edu.upeu.sysgru.service.ProyectoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")



@RestController
@RequestMapping(value = "/api/proyecto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/{id}")
    public Map<String, List<Proyecto>> getProyectos(@PathVariable int id){
        Map<String,List<Proyecto>> proyectos = new HashMap<>();
        proyectos.put("proyectos",proyectoService.getProyecto(id));
        return proyectos;
    }
    @GetMapping("/curso/{id}")
    public Map<String,List<Curso>> getCursos(@PathVariable int id){
        Map<String,List<Curso>> cursos = new HashMap<>();
        cursos.put("cursos",proyectoService.getCursosxPy(id));
        return cursos;
    }
}
