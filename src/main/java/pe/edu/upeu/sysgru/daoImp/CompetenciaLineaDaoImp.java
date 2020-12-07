package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.CompetenciaLineaDao;
import pe.edu.upeu.sysgru.entity.CompetenciaLinea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class CompetenciaLineaDaoImp implements CompetenciaLineaDao {
    private Connection conn;
    private CallableStatement callableStmt;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public List<CompetenciaLinea> getCompetenciasLinea(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("D_CRUD_INSTRUMENTO")
                        .withProcedureName("SPP_GET_COMPETENCIAS_CLID")
                        .returningResultSet("OUT_INSTRUMENTO_CUR",
                                BeanPropertyRowMapper.newInstance(CompetenciaLinea.class));
        Map in = Collections.singletonMap("IDLINEPLAN",id);
        return simpleJdbcCall.executeObject(List.class,in);
    }
}
