package pe.edu.upeu.sysgru.dao;

import oracle.jdbc.proxy.annotation.Pre;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.sql.SqlPregunta;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PreguntaDao {

    List<Pregunta> getPreguntas() throws SQLException;
    List<Pregunta> getPreguntasxins(int id) throws SQLException;
    void createPregunta(SqlPregunta pregunta);
    void updatePregunta(SqlPregunta pregunta);

}