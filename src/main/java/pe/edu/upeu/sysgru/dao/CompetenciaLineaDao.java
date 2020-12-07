package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.CompetenciaLinea;

import java.util.List;

public interface CompetenciaLineaDao {
    List<CompetenciaLinea> getCompetenciasLinea(int id);
}
