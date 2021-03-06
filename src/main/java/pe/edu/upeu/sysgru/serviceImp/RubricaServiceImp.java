package pe.edu.upeu.sysgru.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.RubricaDao;
import pe.edu.upeu.sysgru.entity.*;
import pe.edu.upeu.sysgru.service.RubricaService;

import java.util.List;

@Service
public class RubricaServiceImp implements RubricaService {

    @Autowired
    private RubricaDao rubricaDao;

    @Override
    public void createRubrica(Rubrica rubrica) {
        rubricaDao.createRubrica(rubrica);
    }

    @Override
    public void createIndicador(Indicador indicador) {
        rubricaDao.createIndicador(indicador);
    }

    @Override
    public void createNivelRubrica(NivelRubrica nivelRubrica) {
        rubricaDao.createNivelRubrica(nivelRubrica);
    }

    @Override
    public List<Rubrica_v> getRubricas(int id) {
        return rubricaDao.getRubricas(id);
    }

    @Override
    public List<Rubrica_v> getOnlyRubrica(int id) {
        return rubricaDao.getOnlyRubrica(id);
    }

    @Override
    public List<Indicador> getIndicador(int id) {
        return rubricaDao.getIndicador(id);
    }

    @Override
    public List<Indicador> getOnlyIndicador(int id) {
        return rubricaDao.getOnlyIndicador(id);
    }

    @Override
    public List<NivelesLogro> getNivelesLogro() {
        return rubricaDao.getNivelesLogro();
    }

    @Override
    public List<NivelRubrica_v> getNivelRubrica(int id) {
        return rubricaDao.getNivelRubrica(id);
    }

    @Override
    public List<Admin_v> getVistaAdmin(int idpro, int idpc) {
        return rubricaDao.getVistaAdmin(idpro,idpc);
    }
}
