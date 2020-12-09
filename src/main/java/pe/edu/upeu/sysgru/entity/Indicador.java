package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Indicador {
    private int indicador_id;
    private int rubrica_id;
    private String nombre;
    private Double peso;
    private String estado;
}
