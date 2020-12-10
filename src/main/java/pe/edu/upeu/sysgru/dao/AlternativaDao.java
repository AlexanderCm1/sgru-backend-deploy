package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.Alternativa;
import pe.edu.upeu.sysgru.sql.SqlAlternativa;

import java.sql.SQLException;
import java.util.List;

public interface AlternativaDao {

    void createAlternativa(SqlAlternativa alternativa);
    List<Alternativa> getAlternativas(int id) throws SQLException;
}
