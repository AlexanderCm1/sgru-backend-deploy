package pe.edu.upeu.sysgru.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.RubricaDao;
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
    public List<Rubrica_v> getRubricas(int id) {
        return rubricaDao.getRubricas(id);
    }
}
