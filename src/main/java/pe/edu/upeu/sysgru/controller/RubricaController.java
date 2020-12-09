package pe.edu.upeu.sysgru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.*;
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



    //crear rubrica
    @PostMapping()
    public ResponseEntity<Rubrica> createRubrica(@RequestBody Rubrica rubrica){
        rubricaService.createRubrica(rubrica);
        return new ResponseEntity<Rubrica>(rubrica, HttpStatus.CREATED);
    }
    //listar rubricas x proyecto
    @GetMapping("{id}")
    public Map<String, List<Rubrica_v>> getRubricas(@PathVariable int id){
        Map<String,List<Rubrica_v>> rubricas = new HashMap<>();
        rubricas.put("rubricas", rubricaService.getRubricas(id));
        return rubricas;
    }
    //para listar la rubrica x id
    @GetMapping("indicador/{id}")
    public Map<String,List<Rubrica_v>> getRubrica(@PathVariable int id){
        Map<String,List<Rubrica_v>> rubrica = new HashMap<>();
        rubrica.put("rubrica", rubricaService.getOnlyRubrica(id));
        return rubrica;
    }
    //crear un indicador
    @PostMapping("indicador")
    public ResponseEntity<Indicador> createIndicador(@RequestBody Indicador indicador){
        rubricaService.createIndicador(indicador);
        return new ResponseEntity<Indicador>(indicador,HttpStatus.CREATED);
    }
    //listar indicadores x rubrica
    @GetMapping("indicadores/{id}")
    public Map<String,List<Indicador>> getIndicadores(@PathVariable int id){
        Map<String,List<Indicador>> indicadores = new HashMap<>();
        indicadores.put("indicadores",rubricaService.getIndicador(id));
        return indicadores;
    }
    @GetMapping("niveles_logro")
    public Map<String,List<NivelesLogro>> getNivelesLogro(){
        Map<String,List<NivelesLogro>> nivelesLogro = new HashMap<>();
        nivelesLogro.put("niveles_logro", rubricaService.getNivelesLogro());
        return nivelesLogro;
    }
    @GetMapping("niveles_logro/indicador/{id}")
    public Map<String,List<Indicador>> getOnlyIndicador(@PathVariable int id){
        Map<String,List<Indicador>> indicador = new HashMap<>();
        indicador.put("indicador",rubricaService.getOnlyIndicador(id));
        return indicador;
    }
    @GetMapping("nivel_rubrica/{id}")
    public Map<String,List<NivelRubrica_v>> getNivelesRubrica(@PathVariable int id){
        Map<String,List<NivelRubrica_v>> nivelRubrica = new HashMap<>();
        nivelRubrica.put("niveles_rubrica",rubricaService.getNivelRubrica(id));
        return nivelRubrica;
    }
    @PostMapping("nivel_rubrica")
    public ResponseEntity<NivelRubrica> createNivelRubrica(@RequestBody NivelRubrica nivelRubrica){
        rubricaService.createNivelRubrica(nivelRubrica);
        return new ResponseEntity<>(nivelRubrica,HttpStatus.CREATED);
    }


}
