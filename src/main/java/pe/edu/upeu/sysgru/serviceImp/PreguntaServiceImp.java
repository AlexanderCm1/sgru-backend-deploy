package pe.edu.upeu.sysgru.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.PreguntaDao;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.service.PreguntaService;
import pe.edu.upeu.sysgru.sql.SqlPregunta;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;



@Service
public class PreguntaServiceImp implements PreguntaService {
    @Autowired
    private PreguntaDao preguntaDao;

    @Override
    public List<Pregunta> getPreguntas() throws SQLException {
        return preguntaDao.getPreguntas();
    }

    @Override
    public List<Pregunta> getPreguntasxins(int id) throws SQLException {
        return preguntaDao.getPreguntasxins(id);
    }

    @Override
    public Pregunta getPregunta(BigDecimal id) {
        return preguntaDao.getPregunta(id);
    }

    @Override
    public BigDecimal createPregunta(SqlPregunta pregunta) {
        return preguntaDao.createPregunta(pregunta);
    }

    @Override
    public void updatePregunta(SqlPregunta pregunta) {
        preguntaDao.updatePregunta(pregunta);
    }

    @Override
    public void deletePregunta(int id) {
        preguntaDao.deletePregunta(id);
    }
}
