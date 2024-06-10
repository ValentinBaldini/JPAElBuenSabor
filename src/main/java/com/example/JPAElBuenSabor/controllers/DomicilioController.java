package com.example.JPAElBuenSabor.controllers;

import com.example.JPAElBuenSabor.entities.Domicilio;
import com.example.JPAElBuenSabor.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "domicilio")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            List<Domicilio> domicilios = domicilioService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(domicilios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            Domicilio domicilio = domicilioService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(domicilio);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Domicilio domicilio) {
        try {
            Domicilio savedDomicilio = domicilioService.save(domicilio);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDomicilio);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Domicilio domicilio) {
        try {
            Domicilio updatedDomicilio =domicilioService.update(id, domicilio);
            return ResponseEntity.status(HttpStatus.OK).body(updatedDomicilio);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            boolean deleted = domicilioService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(deleted);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error por favor intente más tarde.\"}");
        }
    }
}

