package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Compra;

public interface CompraService {

    List<Compra> findAll();

    Optional<Compra> findById(long id);

    Compra createCompra(Compra compra);

    Compra updateCompra(Long id, Compra compra);

    void deleteById(long id);
}
