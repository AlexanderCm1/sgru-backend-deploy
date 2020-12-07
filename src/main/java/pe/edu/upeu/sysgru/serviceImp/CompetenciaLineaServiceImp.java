package pe.edu.upeu.sysgru.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.CompetenciaLineaDao;
import pe.edu.upeu.sysgru.entity.CompetenciaLinea;
import pe.edu.upeu.sysgru.service.CompetenciaLineaService;

import java.util.List;

@Service
public class CompetenciaLineaServiceImp implements CompetenciaLineaService {
    @Autowired
    private CompetenciaLineaDao competenciaLineaDao;


    @Override
    public List<CompetenciaLinea> getCompetenciasLinea(int id) {
        return competenciaLineaDao.getCompetenciasLinea(id);
    }
}
