package pe.edu.upeu.sysgru.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.RubricaDao;
import pe.edu.upeu.sysgru.entity.Indicador;
import pe.edu.upeu.sysgru.entity.Rubrica;
import pe.edu.upeu.sysgru.entity.Rubrica_v;
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
}
