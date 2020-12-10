package pe.edu.upeu.sysgru.service;

import pe.edu.upeu.sysgru.entity.Curso;
import pe.edu.upeu.sysgru.entity.Proyecto;

import java.util.List;

public interface ProyectoService {
    List<Proyecto> getProyecto(int id);
    List<Curso> getCursosxPy(int id);
    List<Proyecto> comoBuscar(int id);
}
