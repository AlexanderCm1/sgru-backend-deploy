package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.RubricaDao;
import pe.edu.upeu.sysgru.entity.Rubrica;
import pe.edu.upeu.sysgru.entity.Rubrica_v;

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
    public List<Rubrica_v> getRubricas(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_HEARTH_SHAKER")
                        .withProcedureName("SPP_GET_RUBRICA")
                        .returningResultSet("OUT_RUBRICA",
                                BeanPropertyRowMapper.newInstance(Rubrica_v.class));
        Map in = Collections.singletonMap("IDP",id);

        return simpleJdbcCall.executeObject(List.class,in);
    }
}
