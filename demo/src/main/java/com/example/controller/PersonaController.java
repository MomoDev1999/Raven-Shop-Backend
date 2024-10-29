package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.model.Persona;
import com.example.model.LoginRequest;

import com.example.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> findById(@PathVariable long id) {
        return personaService.findById(id);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable long id, @RequestBody Persona persona) {
        return personaService.updatePersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        personaService.deleteById(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Optional<Persona> persona = personaService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (persona.isPresent()) {
            return "Has iniciado sesión correctamente!";
        } else {
            return "Credenciales incorrectas. Inténtalo de nuevo.";
        }
    }
}