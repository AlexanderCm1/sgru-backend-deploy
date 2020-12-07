package pe.edu.upeu.sysgru.service;

import pe.edu.upeu.sysgru.entity.Instrumento;
import pe.edu.upeu.sysgru.sql.SqlInstrumento;

import java.sql.SQLException;
import java.util.List;

public interface InstrumentoService {
    void createInstrumento(final SqlInstrumento instrumento);
    void updateInstrumento(SqlInstrumento instrumento);
    Instrumento getInstrumento(int id) throws SQLException;
    List<Instrumento> getInstrumentos();
    List<Instrumento> getInstrumentosxsem(int id);
}
