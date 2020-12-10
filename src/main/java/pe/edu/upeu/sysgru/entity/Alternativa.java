package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alternativa {
    private BigDecimal alternativa_id;
    private BigDecimal pregunta_id;
    private String correcta_stado;
    private String nombre;
}

/*
* ALTERNATIVA_ID  NOT NULL NUMBER(8)
PREGUNTA_ID     NOT NULL NUMBER(8)
CORRECTA_ESTADO NOT NULL CHAR(1)
NOMBRE          NOT NULL CLOB
*
* */