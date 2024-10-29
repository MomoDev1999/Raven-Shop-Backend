package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.model.Compra;
import com.example.service.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> findAll() {
        return compraService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Compra> findById(@PathVariable long id) {
        return compraService.findById(id);
    }

    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraService.createCompra(compra);
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@PathVariable long id, @RequestBody Compra compra) {
        return compraService.updateCompra(id, compra);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        compraService.deleteById(id);
    }
}
