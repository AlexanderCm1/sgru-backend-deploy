package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estudiante {
    private int persona_id;
    private String nombres;
    private String apellidos;
    private String codigo_estudiante;
    private String correo_insti;
}
