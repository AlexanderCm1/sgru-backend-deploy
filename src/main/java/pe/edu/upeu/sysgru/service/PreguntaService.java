package pe.edu.upeu.sysgru.service;

import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.sql.SqlPregunta;

import java.sql.SQLException;
import java.util.List;

public interface PreguntaService {
    List<Pregunta> getPreguntas() throws SQLException;
    List<Pregunta> getPreguntasxins(int id) throws SQLException;
    Pregunta getPregunta(int id);
    void createPregunta(SqlPregunta pregunta);
    void updatePregunta(SqlPregunta pregunta);
}
