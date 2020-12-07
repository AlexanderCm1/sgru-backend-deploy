package pe.edu.upeu.sysgru.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.LineaPlanDao;
import pe.edu.upeu.sysgru.entity.LineaPlan;
import pe.edu.upeu.sysgru.service.LineaPlanService;

import java.util.List;


@Service
public class LineaPlanServiceImp implements LineaPlanService {
    @Autowired
    LineaPlanDao lineaPlanDao;

    @Override
    public List<LineaPlan> getLineasPlan(int id) {
        return lineaPlanDao.getLineasPlan(id);
    }
}
