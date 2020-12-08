package pe.edu.upeu.sysgru.service;

import pe.edu.upeu.sysgru.entity.Rubrica;
import pe.edu.upeu.sysgru.entity.Rubrica_v;

import java.util.List;

public interface RubricaService {
    void createRubrica(Rubrica rubrica);
    List<Rubrica_v> getRubricas(int id);
}
