package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.Acceso;

import java.util.List;

public interface AccesoDao {
    List<Acceso> getAccesosbyid(int id);
    List<Acceso> getAccesosbyusername(String username);
}
