package pe.edu.upeu.sysgru.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.RolDao;
import pe.edu.upeu.sysgru.entity.Rol;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RolDaoImp implements RolDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public List<GrantedAuthority> BuscarRolUser(int id) {
        List<GrantedAuthority> autores = new ArrayList<GrantedAuthority>();
        String sql = "SELECT r.rol_id,r.rolname FROM usuario u  \n" +
                "INNER JOIN usuario_rol ur ON u.persona_id=ur.persona_id  \n" +
                "INNER JOIN rol r ON ur.rol_id=r.rol_id \n" +
                "WHERE u.persona_id = ?";
        List<Rol> roles = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<Rol>(Rol.class));
        for(int i=0;i<roles.size();i++) {
            autores.add(new SimpleGrantedAuthority(roles.get(i).getRolname()));
        }
        return autores;
    }
}
