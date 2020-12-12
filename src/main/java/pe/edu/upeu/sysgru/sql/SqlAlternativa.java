package pe.edu.upeu.sysgru.sql;


import pe.edu.upeu.sysgru.entity.Alternativa;

import java.sql.*;

public class SqlAlternativa extends Alternativa implements SQLData {


    @Override
    public String getSQLTypeName() throws SQLException {
        return "D_CRUD_ALTERNATIVAS.ALTERNATIVA_TYPE";
    }

    @Override
    public void readSQL(SQLInput sqlInput, String string) throws SQLException {
        setAlternativa_id(sqlInput.readBigDecimal());
        setPregunta_id(sqlInput.readBigDecimal());
        setCorrecta_estado(sqlInput.readString());
        setNombre(sqlInput.readString());

    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
       sqlOutput.writeBigDecimal(getAlternativa_id());
       sqlOutput.writeBigDecimal(getPregunta_id());
       sqlOutput.writeString(getCorrecta_estado());
       sqlOutput.writeString(getNombre());
    }

}
