package pe.edu.upeu.sysgru.controller;


import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Alternativa;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.service.AlternativaService;
import pe.edu.upeu.sysgru.sql.SqlAlternativa;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = "/api/alternativa", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlternativaController {
    @Autowired
    private AlternativaService alternativaService;

    @GetMapping("{id}")
    public Map<String, List<Alternativa>> getAlternativa(@PathVariable int id) throws SQLException {
        Map<String, List<Alternativa>> alternativas = new HashMap<>();
        alternativas.put("alternativas",alternativaService.getAlternativas(id));
        return alternativas;
    }
    @PostMapping()
    public ResponseEntity<SqlAlternativa> createAlternativa(@RequestBody SqlAlternativa alternativa){
        alternativaService.createAlternativa(alternativa);
        return new ResponseEntity<SqlAlternativa>(alternativa, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<SqlAlternativa> updateAlternativa(@PathVariable int id, @RequestBody SqlAlternativa alternativa){
        alternativa.setAlternativa_id(BigDecimal.valueOf(id));
        alternativaService.updateAlternativa(alternativa);
        return new ResponseEntity<>(alternativa,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> deleteAlternativa(@PathVariable int id){
        Map<String,String> message = new HashMap<>();
        alternativaService.deleteAlternativa(id);
        message.put("message","eliminado");
        return message;
    }

}
