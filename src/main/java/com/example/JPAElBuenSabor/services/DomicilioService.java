package com.example.JPAElBuenSabor.services;

import com.example.JPAElBuenSabor.entities.Domicilio;
import com.example.JPAElBuenSabor.entities.Provincia;
import com.example.JPAElBuenSabor.repositories.DomicilioRepository;
import com.example.JPAElBuenSabor.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements BaseService<Domicilio>{

    @Autowired
    private DomicilioRepository domicilioRepository;

    public List<Domicilio> findAll() {
        return domicilioRepository.findAll();
    }

    public Domicilio findById(Long id) throws Exception {
        Optional<Domicilio> optionalDomicilio = domicilioRepository.findById(id);
        if (optionalDomicilio.isPresent()) {
            return optionalDomicilio.get();
        } else {
            throw new Exception("Domicilio not found");
        }
    }

    public Domicilio save(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    public Domicilio update(Long id, Domicilio domicilio) throws Exception {
        if (domicilioRepository.existsById(id)) {
            domicilio.setId(id);
            return domicilioRepository.save(domicilio);
        } else {
            throw new Exception("Domicilio not found");
        }
    }

    public boolean delete(Long id) throws Exception {
        if (domicilioRepository.existsById(id)) {
            domicilioRepository.deleteById(id);
            return true;
        } else {
            throw new Exception("Domicilio not found");
        }
    }
}

