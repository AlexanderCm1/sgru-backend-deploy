package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.PersonaDao;
import pe.edu.upeu.sysgru.entity.Persona;

@Repository
public class PersonaDaoImp implements PersonaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Persona buscarPersona(int id) {
        String SQL = "select * from persona where persona_id=?";
        return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
    }
}
