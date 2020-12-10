package pe.edu.upeu.sysgru.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.ProyectoDao;
import pe.edu.upeu.sysgru.entity.Curso;
import pe.edu.upeu.sysgru.entity.Proyecto;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@Repository
public class ProyectoDaoimp implements ProyectoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;



    @Override
    public List<Proyecto> getProyecto(int id) {
        simpleJdbcCall  = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_HEARTH_SHAKER")
                        .withProcedureName("SPP_GET_PROYECTOSXSEM")
                        .returningResultSet("OUT_PROYECTO",
                                 BeanPropertyRowMapper.newInstance(Proyecto.class));
        Map in = Collections.singletonMap("IDSEM",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Curso> getCursosxPy(int id) {
        simpleJdbcCall  = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_HEARTH_SHAKER")
                .withProcedureName("SPP_GET_DETALLE_PROYECTO")
                .returningResultSet("OUT_DETALLE",
                        BeanPropertyRowMapper.newInstance(Curso.class));
        Map in = Collections.singletonMap("IDPRO",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Proyecto> comoBuscar(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                            .withCatalogName("D_CRUD_HEARTH_SHAKER")
                            .withProcedureName("SPP_GET_PROYECTO")
                .returningResultSet("OUT_ONLY_PROYECTO",
                        BeanPropertyRowMapper.newInstance(Proyecto.class));
        Map in = Collections.singletonMap("IDPRO",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }
}
