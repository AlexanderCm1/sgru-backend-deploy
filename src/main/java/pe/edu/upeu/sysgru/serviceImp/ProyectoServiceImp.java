package pe.edu.upeu.sysgru.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.ProyectoDao;
import pe.edu.upeu.sysgru.entity.Curso;
import pe.edu.upeu.sysgru.entity.Proyecto;
import pe.edu.upeu.sysgru.service.ProyectoService;

import java.util.List;

@Service
public class ProyectoServiceImp implements ProyectoService {
    @Autowired
    private ProyectoDao proyectoDao;

    @Override
    public List<Proyecto> getProyecto(int id) {
        return proyectoDao.getProyecto(id);
    }

    @Override
    public List<Curso> getCursosxPy(int id) {
        return proyectoDao.getCursosxPy(id);
    }
}
