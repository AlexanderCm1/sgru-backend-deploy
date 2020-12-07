package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pregunta {
    private BigDecimal pregunta_id;
    private BigDecimal instrumento_id;
    private String nombre;
    private BigDecimal peso;
    private String estado;
}


/*
PREGUNTAS_ID   NOT NULL NUMBER(8)
INSTRUMENTO_ID NOT NULL NUMBER(8)
PESO           NOT NULL NUMBER(8,2)
ESTADO         NOT NULL CHAR(1)
NOMBRE         NOT NULL VARCHAR2(100)
 */