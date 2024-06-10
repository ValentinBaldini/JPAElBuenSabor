package com.example.JPAElBuenSabor.controllers;

import com.example.JPAElBuenSabor.entities.Provincia;
import com.example.JPAElBuenSabor.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            List<Provincia> provincias = provinciaService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(provincias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            Provincia provincia = provinciaService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(provincia);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Provincia provincia) {
        try {
            Provincia savedProvincia = provinciaService.save(provincia);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProvincia);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Provincia provincia) {
        try {
            Provincia updatedProvincia = provinciaService.update(id, provincia);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProvincia);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            boolean deleted = provinciaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }
}
