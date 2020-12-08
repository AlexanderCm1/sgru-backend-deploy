package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rubrica {
    private int rubrica_id;
    private int nive_competencias_curso_id;
    private int py_carga_id;
    private String estado;
    private Double peso;
}
