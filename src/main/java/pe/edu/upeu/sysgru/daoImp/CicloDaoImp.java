package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.CicloDao;
import pe.edu.upeu.sysgru.entity.Ciclo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class CicloDaoImp implements CicloDao {
    private Connection conn;
    private CallableStatement callableStmt;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public List<Ciclo> getCiclos(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_INSTRUMENTO")
                        .withProcedureName("SPP_GET_CICLO")
                        .returningResultSet("OUT_CICLO_CUR"
                        , BeanPropertyRowMapper.newInstance(Ciclo.class));
        Map in = Collections.singletonMap("IDSEM",id);

        return simpleJdbcCall.executeObject(List.class,in);
    }
}
