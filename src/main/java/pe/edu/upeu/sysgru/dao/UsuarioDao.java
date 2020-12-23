package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.Usuario;

import java.util.Map;

public interface UsuarioDao {
    Usuario validarUsuario(String username);
    Map<String, Object> datosUsuario(String username);
    Usuario getUsuarioByid(int id);
    Usuario getUsuarioByUsername(String username);
}
