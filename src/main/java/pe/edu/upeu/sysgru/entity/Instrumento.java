package pe.edu.upeu.sysgru.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Instrumento {
     private int instrumento_id;
     private int semestre_id;
     private int cl_id;
     private int utils_id;
     private String titulo;
     private String descripcion;
     private int estado;

}
