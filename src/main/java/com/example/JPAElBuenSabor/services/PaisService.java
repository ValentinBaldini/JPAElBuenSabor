package com.example.JPAElBuenSabor.services;

import com.example.JPAElBuenSabor.entities.Pais;
import com.example.JPAElBuenSabor.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements BaseService<Pais>{

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> buscarPorDenominacion(String denominacion) throws Exception{
        try{
            List<Pais> paises = paisRepository.buscarPorDenominacion(denominacion);
            return paises;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    public Pais findById(Long id) throws Exception {
        Optional<Pais> optionalPais = paisRepository.findById(id);
        if (optionalPais.isPresent()) {
            return optionalPais.get();
        } else {
            throw new Exception("Pais not found");
        }
    }

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais update(Long id, Pais pais) throws Exception {
        if (paisRepository.existsById(id)) {
            pais.setId(id);
            return paisRepository.save(pais);
        } else {
            throw new Exception("Pais not found");
        }
    }

    public boolean delete(Long id) throws Exception {
        if (paisRepository.existsById(id)) {
            paisRepository.deleteById(id);
            return true;
        } else {
            throw new Exception("Pais not found");
        }
    }
}
