package pe.edu.upeu.sysgru.daoImp;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.sql.ARRAY;
import oracle.sql.STRUCT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlReturnArray;
import org.springframework.data.jdbc.support.oracle.SqlStructValue;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.PreguntaDao;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.sql.SqlPregunta;


import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Repository
public class PreguntaDaoImp implements PreguntaDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public List<Pregunta> getPreguntas() throws SQLException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withProcedureName("SPP_GET_PREGUNTAS")
                .declareParameters(
                        new SqlOutParameter("OUT_PREGUNTAS", Types.ARRAY,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"
                ));

        Map<?,?> out = simpleJdbcCall.execute();
        List<Pregunta> preguntas = new ArrayList<>();

        Array oracleObjectArray = (Array) out.get("OUT_PREGUNTAS");
        Object[] objArray = (Object[]) oracleObjectArray.getArray();
        for (int i = 0;i<objArray.length;i++){
            Struct st= (Struct)objArray[i];
            Object[] obj = st.getAttributes();



            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta_id((BigDecimal) obj[0]);
            pregunta.setInstrumento_id((BigDecimal) obj[1]);
            pregunta.setNombre(this.convert((Clob) obj[2]));
            pregunta.setPeso((BigDecimal) obj[3]);
            pregunta.setEstado((String) obj[4]);


            preguntas.add(pregunta);
        }



        return preguntas;
    }

    @Override
    public List<Pregunta> getPreguntasxins(int id) throws SQLException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_PREGUNTAS")
                        .withProcedureName("SPP_GET_PREGUNTAXINSTRUMENTO")
                        .declareParameters(
                        new SqlOutParameter("OUT_PREGUNTAS_INS",Types.ARRAY,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"));
        Map in = Collections.singletonMap("INS_ID",id);
        Map<?,?> out = simpleJdbcCall.execute(in);
        List<Pregunta> preguntas = new ArrayList<>();

        Array oracleObjectArray = (Array) out.get("OUT_PREGUNTAS_INS");
        Object[] objArray = (Object[]) oracleObjectArray.getArray();
        for (int i = 0;i<objArray.length;i++){
            Struct st = (Struct) objArray[i];

            Object[] obj = st.getAttributes();
            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta_id((BigDecimal) obj[0]);
            pregunta.setInstrumento_id((BigDecimal) obj[1]);
            pregunta.setNombre(this.convert((Clob) obj[2]));
            pregunta.setPeso((BigDecimal) obj[3]);
            pregunta.setEstado((String) obj[4]);


            preguntas.add(pregunta);
        }


        return preguntas;
    }

    @Override
    public void createPregunta(SqlPregunta pregunta) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_PREGUNTAS")
                        .withProcedureName("SPP_CREATE_PREGUNTA")
                        .declareParameters(
                         new SqlParameter("IN_PREGUNTA",OracleTypes.STRUCT,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"));

        Map in = Collections.singletonMap("IN_PREGUNTA",pregunta);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void updatePregunta(SqlPregunta pregunta) {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                             .withCatalogName("D_CRUD_PREGUNTAS")
                             .withProcedureName("SPP_UPDATE_PREGUNTA")
                             .declareParameters(
                                     new SqlParameter("P_PREGUNTA",OracleTypes.STRUCT,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"));
            Map in = Collections.singletonMap("IN_PREGUNTA",pregunta);
            simpleJdbcCall.execute(in);
    }

    public String convert(Clob clob) throws SQLException {

        return Math.toIntExact(clob.length()) == 0 //
        ? "" //
        : clob.getSubString(1,Math.toIntExact(clob.length())) ;
    }







/*
    @Override
    public List<Pregunta> getPreguntas() throws SQLException {
        Map<?,?> out = simpleJdbcCall.execute();
        Object[] objArr = (Object[]) ((ARRAY) out.get("LIST_PREGUNTAS")).getArray();

        System.out.println("Length of retrieved batches from database = "+objArr.length);


        for (int i = 0; i< objArr.length; i++){

            STRUCT st = (STRUCT) objArr[i];
            Object[] obj = st.getAttributes();
            Pregunta pregunta = new Pregunta();

            pregunta.setPregunta_id((int) obj[1]);


            preguntas.add(pregunta);

        }
        return preguntas;
    }*/
}
