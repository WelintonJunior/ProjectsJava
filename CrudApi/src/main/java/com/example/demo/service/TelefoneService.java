package com.example.demo.service;

import com.example.demo.api.model.Telefones;
import com.example.demo.api.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelefoneService {
    private final TelefoneRepository telefoneRepository;

    @Autowired
    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public Telefones saveTelefone(Telefones telefone) {
        return telefoneRepository.save(telefone);
    }

    public Telefones getTelefoneById(int id) {
        return telefoneRepository.findById(id).orElse(null);
    }

    public void deleteTelefoneById(int id) { telefoneRepository.deleteById(id); }

    public Telefones updateTelefoneById(int id, Telefones telefone) {
        Optional<Telefones> existingTelefone = telefoneRepository.findById(id);

        if(existingTelefone.isPresent()) {
            Telefones updatedTelefone = existingTelefone.get();
            updatedTelefone.setNumero_telefone(telefone.getNumero_telefone());
            updatedTelefone.setUsuario_id(telefone.getUsuario_id());
            return telefoneRepository.save(updatedTelefone);
        } else {
            return null;
        }
    }
}
