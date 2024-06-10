package com.example.JPAElBuenSabor.services;

import com.example.JPAElBuenSabor.entities.Provincia;
import com.example.JPAElBuenSabor.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService implements BaseService<Provincia>{

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public List<Provincia> findAll() {
        return provinciaRepository.findAll();
    }

    public Provincia findById(Long id) throws Exception {
        Optional<Provincia> optionalProvincia = provinciaRepository.findById(id);
        if (optionalProvincia.isPresent()) {
            return optionalProvincia.get();
        } else {
            throw new Exception("Provincia not found");
        }
    }

    public Provincia save(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public Provincia update(Long id, Provincia provincia) throws Exception {
        if (provinciaRepository.existsById(id)) {
            provincia.setId(id);
            return provinciaRepository.save(provincia);
        } else {
            throw new Exception("Provincia not found");
        }
    }

    public boolean delete(Long id) throws Exception {
        if (provinciaRepository.existsById(id)) {
            provinciaRepository.deleteById(id);
            return true;
        } else {
            throw new Exception("Provincia not found");
        }
    }
}

