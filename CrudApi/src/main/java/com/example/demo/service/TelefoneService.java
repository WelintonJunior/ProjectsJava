package com.example.demo.service;

import com.example.demo.api.model.Telefones;
import com.example.demo.api.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return telefoneRepository.findById(id).get();
    }
}
