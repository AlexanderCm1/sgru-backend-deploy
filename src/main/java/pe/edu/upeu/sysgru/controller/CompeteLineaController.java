package pe.edu.upeu.sysgru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.CompetenciaLinea;
import pe.edu.upeu.sysgru.service.CompetenciaLineaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")


@RestController
@RequestMapping(value = "/api/competencia_linea", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompeteLineaController {
    @Autowired
    private CompetenciaLineaService competenciaLineaService;

    @GetMapping("{id}")
    public Map<String, List<CompetenciaLinea>> getCompetenciasLinea(@PathVariable int id){
        Map<String, List<CompetenciaLinea>> competencias = new HashMap<>();
        competencias.put("competencias_linea",competenciaLineaService.getCompetenciasLinea(id));
        return competencias;
    }

}
