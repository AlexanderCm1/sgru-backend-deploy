package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.SemestreDao;
import pe.edu.upeu.sysgru.entity.Semestre;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

@Repository
public class SemestreDaoImp implements SemestreDao {
    private Connection conn;
    private CallableStatement callableStmt;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public List<Semestre> getSemestres() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_SEMESTRE")
                        .withProcedureName("SPP_READALL_SEMESTRE")
                        .returningResultSet("CURSOR_SEMESTRE",
                                BeanPropertyRowMapper.newInstance(Semestre.class));
        return simpleJdbcCall.executeObject(List.class, Collections.emptyMap());
    }
}
