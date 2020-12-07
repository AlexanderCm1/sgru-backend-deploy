package pe.edu.upeu.sysgru.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.SemestreDao;
import pe.edu.upeu.sysgru.entity.Semestre;
import pe.edu.upeu.sysgru.service.SemestreService;

import java.util.List;

@Service
public class SemestreServiceImp implements SemestreService {
    @Autowired
    private SemestreDao semestreDao;

    @Override
    public List<Semestre> getSemestres() {
        return semestreDao.getSemestres();
    }
}
