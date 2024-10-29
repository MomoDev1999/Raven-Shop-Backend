package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Persona;
import com.example.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> findById(long id) {
        return personaRepository.findById(id);
    }

    @Override
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona updatePersona(Long id, Persona persona) {

        if (personaRepository.existsById(id)) {
            persona.setId(id);
            return personaRepository.save(persona);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> authenticate(String email, String password) {
        return personaRepository.findByEmail(email)
                .filter(persona -> persona.getPassword().equals(password));
    }

}
