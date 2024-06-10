package com.example.JPAElBuenSabor.controllers;

import com.example.JPAElBuenSabor.entities.Pais;
import com.example.JPAElBuenSabor.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            List<Pais> paises = paisService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(paises);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            Pais pais = paisService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(pais);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Pais pais) {
        try {
            Pais savedPais = paisService.save(pais);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPais);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pais pais) {
        try {
            Pais updatedPais = paisService.update(id, pais);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPais);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            boolean deleted = paisService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }
}
