package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.*;

import java.util.List;

public interface RubricaDao {

    void createRubrica(Rubrica rubrica);
    void createIndicador(Indicador indicador);
    void createNivelRubrica(NivelRubrica nivelRubrica);
    List<Rubrica_v> getRubricas(int id);
    List<Rubrica_v> getOnlyRubrica(int id);
    List<Indicador> getIndicador(int id);
    List<Indicador> getOnlyIndicador(int id);
    List<NivelesLogro> getNivelesLogro();
    List<NivelRubrica_v> getNivelRubrica(int id);
    List<Admin_v> getVistaAdmin(int idpro,int idpc);

}
