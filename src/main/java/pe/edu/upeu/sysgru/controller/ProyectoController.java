package pe.edu.upeu.sysgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Curso;
import pe.edu.upeu.sysgru.entity.Proyecto;
import pe.edu.upeu.sysgru.entity.Prueba;
import pe.edu.upeu.sysgru.service.ProyectoService;

import java.sql.Array;
import java.util.*;

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

    @GetMapping("union/{id}")
    public ArrayList getUnion(@PathVariable int id){
        Prueba prueba = new Prueba();
        Map<String,List<Proyecto>> proyecto = new HashMap<>();
        Map<String,List<Curso>> cursos = new HashMap<>();
        proyecto.put("proyecto",proyectoService.comoBuscar(id));
        prueba.setProyecto(proyecto);
        cursos.put("cursos",proyectoService.getCursosxPy(id));
        prueba.setCursos(cursos);
        ArrayList loba = new ArrayList();
        loba.add(proyecto);
        loba.add(cursos);


        return  loba;
    }


    @GetMapping("/curso/{id}")
    public Map<String,List<Curso>> getCursos(@PathVariable int id){
        Map<String,List<Curso>> cursos = new HashMap<>();
        cursos.put("cursos",proyectoService.getCursosxPy(id));
        return cursos;
    }
}
