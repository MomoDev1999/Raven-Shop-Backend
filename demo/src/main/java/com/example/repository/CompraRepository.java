package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
