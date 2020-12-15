package pe.edu.upeu.sysgru.sql;


import oracle.jdbc.driver.OracleConnection;
import oracle.sql.CLOB;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.sysgru.entity.Pregunta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class SqlPregunta extends Pregunta implements SQLData {






    @Override
    public String getSQLTypeName() throws SQLException {
        return "D_CRUD_PREGUNTAS.PREGUNTA_TYPE";
    }

    @Override
    public void readSQL(SQLInput sqlInput, String string) throws SQLException {
            setPregunta_id(sqlInput.readBigDecimal());
            setInstrumento_id(sqlInput.readBigDecimal());
            setPeso(sqlInput.readBigDecimal());
            setEstado(sqlInput.readString());
            setNombre(sqlInput.readString());
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
            sqlOutput.writeBigDecimal(getPregunta_id());
            sqlOutput.writeBigDecimal(getInstrumento_id());
            sqlOutput.writeBigDecimal(getPeso());
            sqlOutput.writeString(getEstado());
            sqlOutput.writeString(getNombre());
    }

    public String clobToString(Clob data) {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = data.getCharacterStream();
            BufferedReader br = new BufferedReader(reader);

            String line;
            while(null != (line = br.readLine())) {
                sb.append(line);
            }
            br.close();
        } catch (SQLException e) {
            // handle this exception
        } catch (IOException e) {
            // handle this exception
        }
        return sb.toString();
    }

    public Clob getClob(String data) throws SQLException {
        Clob myClob = new javax.sql.rowset.serial.SerialClob(data.toCharArray());

         return myClob;
    }
    public String convert(Clob clob) throws SQLException {

        return Math.toIntExact(clob.length()) == 0 //
                ? "" //
                : clob.getSubString(1,Math.toIntExact(clob.length())) ;
    }





}
