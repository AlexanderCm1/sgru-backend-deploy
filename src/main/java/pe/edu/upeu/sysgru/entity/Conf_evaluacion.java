package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Conf_evaluacion {
    private int conf_evaluacion_id;
    private int conf_py_id;
    private String nombre;
    private Double peso;
    private String estado;
}
