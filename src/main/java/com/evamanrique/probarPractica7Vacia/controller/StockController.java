package com.evamanrique.probarPractica7Vacia.controller;

import com.evamanrique.probarPractica7Vacia.model.Dispositivo;
import com.evamanrique.probarPractica7Vacia.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.Iterable;

@RestController
@RequestMapping("/api/v1")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stock")
    public ResponseEntity<Iterable<Dispositivo>> retrieveDispositivos(@RequestParam(required = false) String existencias) {

        Iterable<Dispositivo> respuesta = stockService.retrieveDispositivos(existencias);
        return ResponseEntity.ok().body(respuesta);

    }

    @PutMapping("/stock/{id}/")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable String id, @RequestBody Dispositivo dispositivo) {

        Dispositivo newDispositivo = stockService.updateDispositivo(id,dispositivo);
        if(newDispositivo == null)
        {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newDispositivo);
    }
    /*
    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo){
        Dispositivo newDispositivo2 = stockService.createDispositivo(dispositivo);
        return ResponseEntity.ok().body(newDispositivo2);
    }
     */

    @DeleteMapping("/stock/{id}/")
    public ResponseEntity<Dispositivo> deleteDispositivo(@PathVariable String id)
    {
        stockService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stock/{id}/")
    public ResponseEntity<Dispositivo> retrieveDispositivo(@PathVariable String id) {

        Dispositivo respuesta = stockService.retrieveDispositivo(id);
        return ResponseEntity.ok().body(respuesta);

    }


}