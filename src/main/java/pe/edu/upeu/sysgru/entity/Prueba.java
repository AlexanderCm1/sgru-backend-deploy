package pe.edu.upeu.sysgru.entity;

import java.util.List;
import java.util.Map;

public class Prueba {
    private Map<String, List<Proyecto>> proyecto;
    private Map<String, List<Curso>> cursos;

    public Map<String, List<Proyecto>> getProyecto() {
        return proyecto;
    }

    public Map<String, List<Curso>> getCursos() {
        return cursos;
    }

    public void setProyecto(Map<String, List<Proyecto>> proyecto) {
        this.proyecto = proyecto;
    }

    public void setCursos(Map<String, List<Curso>> cursos) {
        this.cursos = cursos;
    }
}
