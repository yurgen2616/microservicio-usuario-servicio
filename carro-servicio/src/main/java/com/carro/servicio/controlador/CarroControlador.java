package com.carro.servicio.controlador;

import com.carro.servicio.entidades.Carro;
import com.carro.servicio.servicio.CarroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/carro")
@RestController
public class CarroControlador {

    @Autowired
    private CarroServicio carroServicio;

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroServicio.getAll();
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id")int id){
        Carro carro = carroServicio.getCarroById(id);
        if (carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
        Carro nuevoCarro = carroServicio.save(carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId")int id) {
        List<Carro> carros =carroServicio.byUsuarioId(id);
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
}
