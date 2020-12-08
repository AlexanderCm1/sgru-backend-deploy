package pe.edu.upeu.sysgru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Rubrica;
import pe.edu.upeu.sysgru.entity.Rubrica_v;
import pe.edu.upeu.sysgru.service.RubricaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = "/api/rubrica", produces = MediaType.APPLICATION_JSON_VALUE)
public class RubricaController {
    @Autowired
    private RubricaService rubricaService;




    @PostMapping()
    public ResponseEntity<Rubrica> createRubrica(@RequestBody Rubrica rubrica){
        rubricaService.createRubrica(rubrica);
        return new ResponseEntity<Rubrica>(rubrica, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Map<String, List<Rubrica_v>> getRubricas(@PathVariable int id){
        Map<String,List<Rubrica_v>> rubricas = new HashMap<>();
        rubricas.put("rubricas", rubricaService.getRubricas(id));
        return rubricas;
    }
}
