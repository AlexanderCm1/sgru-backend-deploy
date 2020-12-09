package pe.edu.upeu.sysgru;


import oracle.jdbc.OracleConnection;
import oracle.sql.CLOB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.upeu.sysgru.dao.*;
import pe.edu.upeu.sysgru.entity.CompetenciaLinea;
import pe.edu.upeu.sysgru.entity.Pregunta;
import pe.edu.upeu.sysgru.entity.Rubrica;
import pe.edu.upeu.sysgru.sql.SqlInstrumento;
import pe.edu.upeu.sysgru.sql.SqlPregunta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;

@SpringBootTest
class SysgruApplicationTests {



	@Autowired
	private InstrumentoDao instrumentoDao;
	@Autowired
	private SemestreDao semestreDao;
	@Autowired
	private LineaPlanDao lineaPlanDao;
	@Autowired
	private CompetenciaLineaDao competenciaLineaDao;
	@Autowired
	private CicloDao cicloDao;
	@Autowired
	private PreguntaDao preguntaDao;
	@Autowired
	private ProyectoDao proyectoDao;
	@Autowired
	private RubricaDao rubricaDao;


	SysgruApplicationTests() throws SQLException {
	}

	@Test
	void contextLoads() throws SQLException {
		/*
		System.out.println("jajaja");
		System.out.println(instrumentoDao.getInstrumento(1));
		*/

		/*
		SqlInstrumento instrumento = new SqlInstrumento();
		instrumento.setSemestre_id(102);
		instrumento.setCl_id(4);
		instrumento.setTitulo("Duendes del conde");
		instrumento.setDescripcion("jajajaajaj");
		instrumentoDao.createInstrumento(instrumento);

		/*
		update
		SqlInstrumento instrumento = new SqlInstrumento();
		instrumento.setSemestre_id(102);
		instrumento.setCl_id(4);
		instrumento.setInstrumento_id(8);
		instrumentoDao.updateInstrumento(instrumento);
		 */
		//System.out.println(instrumentoDao.getInstrumentos());

		//System.out.println(preguntaDao.getPreguntas());

		/*
		//CREAR UNA PREGUNTA (INSERTAR)
		SqlPregunta pregunta = new SqlPregunta();
		pregunta.setInstrumento_id(BigDecimal.valueOf(424));
		pregunta.setNombre(("Prueba si conecta :)"));
		pregunta.setPeso(BigDecimal.valueOf(5.2));
		preguntaDao.createPregunta(pregunta);
		*/

		/*
		UPDATE pregunta
		SqlPregunta pregunta = new SqlPregunta();
		pregunta.setInstrumento_id(BigDecimal.valueOf(403));
		pregunta.setNombre("AJAJAJAJJAAJAJAJ");
		pregunta.setPeso(BigDecimal.valueOf(10));
		pregunta.setPregunta_id(BigDecimal.valueOf(101));
		preguntaDao.updatePregunta(pregunta);

		 */
		//System.out.println(preguntaDao.getPreguntasxins(424));
		//System.out.println(proyectoDao.getCursosxPy(1));
		/*
		Rubrica rubrica = new Rubrica();
		rubrica.setPy_carga_id(41);
		rubrica.setPeso(20.0);
		rubricaDao.createRubrica(rubrica);*/
		//System.out.println(rubricaDao.getRubricas(1));
		//System.out.println(rubricaDao.getOnlyRubrica(81));
		//System.out.println(rubricaDao.getIndicador(21));
		//System.out.println(rubricaDao.getNivelesLogro());
		//System.out.println(rubricaDao.getOnlyIndicador(21));
		System.out.println(rubricaDao.getNivelRubrica(41));
	}

}
