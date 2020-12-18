package pe.edu.upeu.sysgru.controller;


import oracle.jdbc.proxy.annotation.Pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.service.PreguntaService;
import pe.edu.upeu.sysgru.sql.SqlInstrumento;
import pe.edu.upeu.sysgru.sql.SqlPregunta;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    @GetMapping("detail/{id}")
    public Map<String,Pregunta> getPregunta(@PathVariable BigDecimal id){
        Map<String,Pregunta> pregunta = new HashMap<>();
        pregunta.put("pregunta", preguntaService.getPregunta(id));
        return pregunta;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SqlPregunta> createPregunta(@RequestBody SqlPregunta pregunta){
        pregunta.setPregunta_id(preguntaService.createPregunta(pregunta));
        return new ResponseEntity<>(pregunta,HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<SqlPregunta> updatePregunta(@PathVariable BigDecimal id, @RequestBody SqlPregunta pregunta){
        pregunta.setPregunta_id(id);
        preguntaService.updatePregunta(pregunta);
        return new ResponseEntity<SqlPregunta>(pregunta,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> deletePregunta(@PathVariable int id){
        preguntaService.deletePregunta(id);
        Map<String,String> message = new HashMap<>();
        message.put("message","eliminado");
        return message;
    }
}
