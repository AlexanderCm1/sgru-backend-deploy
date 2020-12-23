package pe.edu.upeu.sysgru.dao;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface RolDao {
    List<GrantedAuthority> BuscarRolUser(int id);
}
