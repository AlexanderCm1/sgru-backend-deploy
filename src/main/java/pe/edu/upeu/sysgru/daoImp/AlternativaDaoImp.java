package pe.edu.upeu.sysgru.daoImp;


import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlStructValue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.AlternativaDao;
import pe.edu.upeu.sysgru.entity.Alternativa;
import pe.edu.upeu.sysgru.sql.SqlAlternativa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;


@Repository
public class AlternativaDaoImp implements AlternativaDao {

    private static final String CATALOG_NAME = "D_CRUD_ALTERNATIVAS";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public void createAlternativa(SqlAlternativa alternativa) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_CREATE_ALTERNATIVA")
                        .declareParameters(
                                new SqlParameter("IN_ALTERNATIVA", OracleTypes.STRUCT,"D_CRUD_ALTERNATIVAS.ALTERNATIVA_TYPE")
                        );
        Map in = Collections.singletonMap("IN_ALTERNATIVA", alternativa);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void updateAlternativa(SqlAlternativa alternativa) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_UPDATE_ALTERNATIVA")
                        .declareParameters(
                          new SqlParameter("P_ALTERNATIVA", OracleTypes.STRUCT,"D_CRUD_ALTERNATIVAS.ALTERNATIVA_TYPE")
                        );
        Map in = Collections.singletonMap("IN_ALTERNATIVA",alternativa);
        simpleJdbcCall.execute(in);
    }

    @Override
    public List<Alternativa> getAlternativas(int id) throws SQLException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_GET_ALTERNATIVASXPREGUN")
                        .declareParameters(
                                new SqlOutParameter("OUT_ALTERNATIVAS", Types.ARRAY,"D_CRUD_ALTERNATIVAS.ALTERNATIVAS_TYPE")
                        );
        Map in = Collections.singletonMap("IN_PRE_ID",id);
        Map<?,?> out = simpleJdbcCall.execute(in);
        List<Alternativa> alternativas = new ArrayList<>();

        Array oracleObjectArray = (Array) out.get("OUT_ALTERNATIVAS");
        Object[] objArray = (Object[]) oracleObjectArray.getArray();
        for (int i = 0; i < objArray.length; i++) {
            Struct st = (Struct) objArray[i];
            Object[] obj = st.getAttributes();

            Alternativa alternativa = new Alternativa();
            alternativa.setAlternativa_id((BigDecimal) obj[0]);
            alternativa.setPregunta_id((BigDecimal) obj[1]);
            alternativa.setCorrecta_estado((String) obj[2]);
            alternativa.setNombre(convert((Clob) obj[3]));


            alternativas.add(alternativa);
        }
        return alternativas;
    }

    @Override
    public void deleteAlternativa(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_DELETE_ALTERNATIVA")
                        .declareParameters(
                            new SqlParameter("IN_ALTERNATIVA_ID", OracleTypes.NUMBER)
                        );
        Map in = Collections.singletonMap("IN_ALTERNATIVA_ID",id);
        simpleJdbcCall.execute(in);
    }

    public String convert(Clob clob) throws SQLException {

        return Math.toIntExact(clob.length()) == 0 //
                ? "" //
                : clob.getSubString(1,Math.toIntExact(clob.length())) ;
    }
}
