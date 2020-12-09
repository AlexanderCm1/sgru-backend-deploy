package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.RubricaDao;
import pe.edu.upeu.sysgru.entity.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@Repository
public class RubricaDaoImp implements RubricaDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public void createRubrica(Rubrica rubrica) {
        String sql = "DECLARE\n" +
                "IN_RUBRICA RUBRICA%ROWTYPE;\n" +
                "BEGIN\n" +
                "    IN_RUBRICA.PY_CARGA_ID:= ?;\n" +
                "    IN_RUBRICA.PESO:= ?;\n" +
                "    D_CRUD_HEARTH_SHAKER.SPP_CREATE_RUBRICA(IN_RUBRICA); \n" +
                "END; ";
         jdbcTemplate.update(sql,rubrica.getPy_carga_id(),rubrica.getPeso());
    }

    @Override
    public void createIndicador(Indicador indicador) {
        String sql = "DECLARE\n" +
                "IN_INDICADOR INDICADOR%ROWTYPE;\n" +
                "BEGIN\n" +
                "    IN_INDICADOR.RUBRICA_ID:= ?;\n" +
                "    IN_INDICADOR.NOMBRE:= ?;\n" +
                "    IN_INDICADOR.PESO := ?;\n" +
                "    D_CRUD_HEARTH_SHAKER.SPP_CREATE_INDICADOR(IN_INDICADOR); \n" +
                "END;";
        jdbcTemplate.update(sql,indicador.getRubrica_id(),indicador.getNombre(),indicador.getPeso());
    }

    @Override
    public void createNivelRubrica(NivelRubrica nivelRubrica) {
        String sql = "DECLARE\n" +
                "IN_NIVEL_RUBRI nivel_rubrica%ROWTYPE;\n" +
                "BEGIN\n" +
                "    IN_NIVEL_RUBRI.NIVEL_LOGRO_ID:= ?;\n" +
                "    IN_NIVEL_RUBRI.INDICADOR_ID:= ?;\n" +
                "    IN_NIVEL_RUBRI.DESCRIPCION := ?;\n" +
                "    D_CRUD_HEARTH_SHAKER.SPP_CREATE_NIVEL_RUBRICA(IN_NIVEL_RUBRI); \n" +
                "END;";
        jdbcTemplate.update(sql,nivelRubrica.getNivel_logro_id(),nivelRubrica.getIndicador_id(),nivelRubrica.getDescripcion());
    }

    @Override
    public List<Rubrica_v> getRubricas(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_HEARTH_SHAKER")
                        .withProcedureName("SPP_GET_RUBRICA")
                        .returningResultSet("OUT_RUBRICA",
                                BeanPropertyRowMapper.newInstance(Rubrica_v.class));
        Map in = Collections.singletonMap("IDP",id);

        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Rubrica_v> getOnlyRubrica(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                         .withCatalogName("D_CRUD_HEARTH_SHAKER")
                         .withProcedureName("SPP_GET_ONLYRUBRICA")
                         .returningResultSet("OUT_RUBRIC",
                                 BeanPropertyRowMapper.newInstance(Rubrica_v.class));
        Map in = Collections.singletonMap("IDRUBRIC",id);

        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Indicador> getIndicador(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("D_CRUD_HEARTH_SHAKER")
                            .withProcedureName("SPP_GET_INDICADOR")
                            .returningResultSet("OUT_INDICADOR",
                                    BeanPropertyRowMapper.newInstance(Indicador.class));
        Map in = Collections.singletonMap("IDRU",id);

        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Indicador> getOnlyIndicador(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_HEARTH_SHAKER")
                        .withProcedureName("SPP_GET_ONLYINDICADOR")
                .returningResultSet("OUT_INDI",
                        BeanPropertyRowMapper.newInstance(Indicador.class));
        Map in = Collections.singletonMap("IDINDI",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<NivelesLogro> getNivelesLogro() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("D_CRUD_HEARTH_SHAKER")
                            .withProcedureName("SPP_GET_NIVELES_LOGRO")
                            .returningResultSet("OUT_NIVELES",
                                    BeanPropertyRowMapper.newInstance(NivelesLogro.class));
        return simpleJdbcCall.executeObject(List.class);
    }

    @Override
    public List<NivelRubrica_v> getNivelRubrica(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_HEARTH_SHAKER")
                        .withProcedureName("SPP_GET_NIVEL_RUBRICA")
                        .returningResultSet("OUT_NIVEL_RUBRICA",
                                BeanPropertyRowMapper.newInstance(NivelRubrica_v.class));
        Map in = Collections.singletonMap("IDIN",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }

}
