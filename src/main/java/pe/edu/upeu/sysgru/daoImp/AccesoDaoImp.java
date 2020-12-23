package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.AccesoDao;
import pe.edu.upeu.sysgru.entity.Acceso;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AccesoDaoImp implements AccesoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public List<Acceso> getAccesosbyid(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_ACCESO_PRUEBA")
                .withProcedureName("SPP_GET_ACCESO_BYID")
                .returningResultSet("OUT_ACCESO",
                        BeanPropertyRowMapper.newInstance(Acceso.class));
        Map in = Collections.singletonMap("IN_PERSONA_ID",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }

    @Override
    public List<Acceso> getAccesosbyusername(String username) {
        return null;
    }
}
