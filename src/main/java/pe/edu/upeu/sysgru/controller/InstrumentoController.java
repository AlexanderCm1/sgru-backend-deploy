package pe.edu.upeu.sysgru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgru.entity.Instrumento;
import pe.edu.upeu.sysgru.service.InstrumentoService;
import org.springframework.http.MediaType;
import pe.edu.upeu.sysgru.sql.SqlInstrumento;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(value = "/api/instrumento", produces = MediaType.APPLICATION_JSON_VALUE)
public class InstrumentoController {
    @Autowired
    private InstrumentoService instrumentoService;


    @GetMapping
    public Map<String, List<Instrumento>> getInstrumentos(){

        Map<String,List<Instrumento>> instrumentos = new HashMap<String, List<Instrumento>>();
        instrumentos.put("instrumentos", instrumentoService.getInstrumentos());
        return instrumentos;

    }
    @GetMapping("/{id}")
    public Map<String, Instrumento> getInstrumento(@PathVariable int id) throws SQLException{
        Map<String,Instrumento> instrumento = new HashMap<>();
        instrumento.put("instrumento",instrumentoService.getInstrumento(id));
        return instrumento;
    }
    /*
    @GetMapping("/{id}")
    public SqlInstrumento getInstrumento(@PathVariable int id) throws SQLException{

        return instrumentoService.getInstrumento(id);
    }*/
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SqlInstrumento> createInstrumento(@RequestBody SqlInstrumento instrumento){
        instrumentoService.createInstrumento(instrumento);
        return new ResponseEntity<SqlInstrumento>(instrumento,HttpStatus.CREATED);

        /*
        Map<String,SqlInstrumento> response = new HashMap<String, SqlInstrumento>();
        instrumentoService.createInstrumento(instrumento);
        response.put("instrumento",instrumentoService.createInstrumento(instrumento));
        return response;*/
    }
    @PutMapping("/{id}")
    public ResponseEntity<SqlInstrumento> updateInstrumento(@PathVariable int id,@RequestBody SqlInstrumento instrumento){
        instrumento.setInstrumento_id(id);
        instrumentoService.updateInstrumento(instrumento);
        return new ResponseEntity<SqlInstrumento>(instrumento,HttpStatus.OK);
    }
    @GetMapping("sem/{id}")
    public Map<String,List<Instrumento>> getInstrumentoXsem(@PathVariable int id){
        Map<String,List<Instrumento>> instrumentoxsem = new HashMap<>();
        instrumentoxsem.put("instrumentos",instrumentoService.getInstrumentosxsem(id));
        return instrumentoxsem;
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> deleteInstrumento(@PathVariable int id){
        Map<String,String> message = new HashMap<>();
        instrumentoService.deleteInstrumento(id);
        message.put("message","eliminado");
        return message;
    }

}
