package pe.edu.upeu.sysgru.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgru.dao.AlternativaDao;
import pe.edu.upeu.sysgru.entity.Alternativa;
import pe.edu.upeu.sysgru.service.AlternativaService;
import pe.edu.upeu.sysgru.sql.SqlAlternativa;

import java.sql.SQLException;
import java.util.List;


@Service
public class AlternativaServiceImp implements AlternativaService {

    @Autowired
    private AlternativaDao alternativaDao;

    @Override
    public void createAlternativa(SqlAlternativa alternativa) {
        alternativaDao.createAlternativa(alternativa);
    }

    @Override
    public List<Alternativa> getAlternativas(int id) throws SQLException {
        return alternativaDao.getAlternativas(id);
    }
}
