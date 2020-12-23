package pe.edu.upeu.sysgru.daoImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysgru.dao.UsuarioDao;
import pe.edu.upeu.sysgru.entity.Usuario;

import java.util.Map;

@Repository
public class UsuarioDaoImp implements UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Usuario validarUsuario(String username) {
        String SQL = "select * from usuario where username=?";
        Usuario usuario = jdbcTemplate.queryForObject(SQL, new Object[] {username}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
        return usuario;
    }

    @Override
    public Map<String, Object> datosUsuario(String username) {
        String sql = "SELECT u.persona_id,r.rol_id,p.nombres ||' '|| p.apellidos as nombre_completo,u.username,r.rolname FROM persona p \n" +
                "JOIN usuario u ON p.persona_id = u.persona_id \n" +
                "JOIN usuario_rol ur ON u.persona_id = ur.persona_id  \n" +
                "JOIN rol r ON ur.rol_id=r.rol_id \n" +
                "                where u.username = ?";
        Map<String, Object> map= jdbcTemplate.queryForMap(sql, username);
        return map;
    }

    @Override
    public Usuario getUsuarioByid(int id) {
        String SQL = "select *from usuario where persona_id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Usuario>(Usuario.class));
    }

    @Override
    public Usuario getUsuarioByUsername(String username) {
        String SQL = "SELECT *FROM usuario WHERE username=?";
        return jdbcTemplate.queryForObject(SQL, new Object[] {username}, new BeanPropertyRowMapper<Usuario>(Usuario.class));

    }
}
