package pe.edu.upeu.sysgru.controller;


import oracle.jdbc.proxy.annotation.Pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.service.PreguntaService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")



@RestController
@RequestMapping(value = "/api/pregunta", produces = MediaType.APPLICATION_JSON_VALUE)
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public Map<String, List<Pregunta>> getPreguntas() throws SQLException {
        Map<String,List<Pregunta>> preguntas = new HashMap<>();
        preguntas.put("preguntas",preguntaService.getPreguntas());
        return preguntas;
    }
    @GetMapping("/{id}")
    public Map<String,List<Pregunta>> getPreguntasxins(@PathVariable int id) throws SQLException {
        Map<String,List<Pregunta>> preguntas = new HashMap<>();
        preguntas.put("preguntas",preguntaService.getPreguntasxins(id));
        return preguntas;
    }
}
