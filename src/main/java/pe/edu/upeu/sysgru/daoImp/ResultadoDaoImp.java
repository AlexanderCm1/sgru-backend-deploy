package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.ResultadoDao;
import pe.edu.upeu.sysgru.entity.Conf_evaluacion;
import pe.edu.upeu.sysgru.entity.Conf_py;
import pe.edu.upeu.sysgru.entity.Estudiante;
import sun.invoke.empty.Empty;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class ResultadoDaoImp implements ResultadoDao {


    private static final String CATALOG_NAME = "D_CRUD_RESULTADOS";


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public List<Estudiante> getEstudiante() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_GET_ESTUDIANTES")
                        .returningResultSet("OUT_ESTUDIANTE",
                                BeanPropertyRowMapper.newInstance(Estudiante.class));

        return simpleJdbcCall.executeObject(List.class, Collections.emptyMap());
    }

    @Override
    public List<Conf_py> getConf_py(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_GET_CONF_PY")
                        .returningResultSet("OUT_CONF_PY",
                                BeanPropertyRowMapper.newInstance(Conf_py.class));
        Map in = Collections.singletonMap("IN_SEMESTRE",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Conf_evaluacion> getConf_evaluacion(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName(CATALOG_NAME)
                        .withProcedureName("SPP_GET_CONF_EVA")
                        .returningResultSet("OUT_CONF_EVA",
                                BeanPropertyRowMapper.newInstance(Conf_evaluacion.class));
        Map in = Collections.singletonMap("IN_CONF_PY_ID",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }
}
