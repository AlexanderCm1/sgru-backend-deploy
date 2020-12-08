package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rubrica_v {
    private int rubrica_id;
    private int py_carga_id;
    private int py_id;
    private String curso;
    private Double peso;
    private String estado;
}
