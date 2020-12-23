package pe.edu.upeu.sysgru.service;

import pe.edu.upeu.sysgru.entity.Conf_evaluacion;
import pe.edu.upeu.sysgru.entity.Conf_py;
import pe.edu.upeu.sysgru.entity.Estudiante;

import java.util.List;

public interface ResultadoService {
    List<Estudiante> getEstudiante();
    List<Conf_py> getConf_py(int id);
    List<Conf_evaluacion> getConf_evaluacion(int id);
}
