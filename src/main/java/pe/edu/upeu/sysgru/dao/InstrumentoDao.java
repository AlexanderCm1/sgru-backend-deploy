package pe.edu.upeu.sysgru.dao;


import pe.edu.upeu.sysgru.entity.Instrumento;
import pe.edu.upeu.sysgru.sql.SqlInstrumento;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface InstrumentoDao {
    void createInstrumento(final SqlInstrumento instrumento);
    void updateInstrumento(SqlInstrumento instrumento);
    Instrumento getInstrumento(int id) throws SQLException;
    List<Instrumento> getInstrumentos();
    List<Instrumento> getInstrumentosxsem(int id);
    void deleteInstrumento(int id);
}
