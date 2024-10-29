package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Persona;

public interface PersonaService {

    List<Persona> findAll();

    Optional<Persona> findById(long id);

    Persona createPersona(Persona persona);

    Persona updatePersona(Long id, Persona persona);

    void deleteById(long id);

    Optional<Persona> authenticate(String email, String password);
}