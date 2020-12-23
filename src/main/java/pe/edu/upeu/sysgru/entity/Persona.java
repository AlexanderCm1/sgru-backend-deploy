package pe.edu.upeu.sysgru.entity;


import lombok.Data;




@Data
public class Persona {
    int persona_id;
    String nombres;
    String apellidos;
    int tipo_doc_id;
    String n_doc;
    String sexo;
    String fecha_nac;
    String correo;
    String telefono;
    int estado_civil_id;
}
