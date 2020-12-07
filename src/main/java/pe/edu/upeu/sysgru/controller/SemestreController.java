package pe.edu.upeu.sysgru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.sysgru.entity.Semestre;
import pe.edu.upeu.sysgru.service.SemestreService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = "/api/semestre", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemestreController {
    @Autowired
    private SemestreService semestreService;


    @GetMapping
    public Map<String, List<Semestre>> getSemestres(){
        Map<String,List<Semestre>> semestres = new HashMap<>();
        semestres.put("semestres",semestreService.getSemestres());
            return semestres;
    }
}
