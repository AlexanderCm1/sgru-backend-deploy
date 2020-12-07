package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.LineaPlanDao;
import pe.edu.upeu.sysgru.entity.LineaPlan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class LineaPlanImp implements LineaPlanDao {
    private Connection conn;
    private CallableStatement callableStmt;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public List<LineaPlan> getLineasPlan(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_INSTRUMENTO")
                        .withProcedureName("SPP_GET_LINEAXPLAN")
                        .returningResultSet("OUT_LINEAXPLAN_CUR", BeanPropertyRowMapper.newInstance(LineaPlan.class));
        Map in = Collections.singletonMap("IDPLAN",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }
}
