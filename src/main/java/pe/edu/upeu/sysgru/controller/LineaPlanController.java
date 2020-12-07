package pe.edu.upeu.sysgru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.LineaPlan;
import pe.edu.upeu.sysgru.service.LineaPlanService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")


@RestController
@RequestMapping(value = "/api/lineas_plan", produces = MediaType.APPLICATION_JSON_VALUE)
public class LineaPlanController {
    @Autowired
    LineaPlanService lineaPlanService;

    @GetMapping("{id}")
    public Map<String, List<LineaPlan>> getLineasPlan(@PathVariable int id){
        Map<String,List<LineaPlan>> lineasPlan = new HashMap<>();
        lineasPlan.put("lineas_plan",lineaPlanService.getLineasPlan(id));
        return lineasPlan;
    }
}
