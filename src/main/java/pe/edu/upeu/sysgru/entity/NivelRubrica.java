package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NivelRubrica {
    private int nivel_rubrica_id;
    private int nivel_logro_id;
    private int indicador_id;
    private String descripcion;
    private String estado;
}
