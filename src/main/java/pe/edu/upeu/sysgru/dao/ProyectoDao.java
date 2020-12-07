package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.Curso;
import pe.edu.upeu.sysgru.entity.Proyecto;

import java.util.List;

public interface ProyectoDao {
    List<Proyecto> getProyecto(int id);
    List<Curso> getCursosxPy(int id);
}
