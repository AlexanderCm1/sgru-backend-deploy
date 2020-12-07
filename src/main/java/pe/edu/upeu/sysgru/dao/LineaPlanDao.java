package pe.edu.upeu.sysgru.dao;

import pe.edu.upeu.sysgru.entity.LineaPlan;

import java.util.List;

public interface LineaPlanDao {
    List<LineaPlan> getLineasPlan(int id);
}
