package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NivelRubrica_v {
    private int nivel_rubrica_id;
    private int indicador_id;
    private String nombre;
    private Double peso;
    private String descripcion;
}
