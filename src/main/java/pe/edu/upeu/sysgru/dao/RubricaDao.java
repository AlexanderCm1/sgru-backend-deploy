package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.Indicador;
import pe.edu.upeu.sysgru.entity.Rubrica;
import pe.edu.upeu.sysgru.entity.Rubrica_v;

import java.util.List;

public interface RubricaDao {

    void createRubrica(Rubrica rubrica);
    void createIndicador(Indicador indicador);
    List<Rubrica_v> getRubricas(int id);
    List<Rubrica_v> getOnlyRubrica(int id);
    List<Indicador> getIndicador(int id);

}
