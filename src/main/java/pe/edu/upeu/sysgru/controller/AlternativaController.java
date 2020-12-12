package pe.edu.upeu.sysgru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.sysgru.entity.Alternativa;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.service.AlternativaService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
