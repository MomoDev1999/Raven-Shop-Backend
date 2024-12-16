package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Producto;
import com.example.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        // Verificar si el producto existe
        if (productoRepository.existsById(id)) {
            // Eliminar los ratings asociados
            ratingService.findByProductoId(id).forEach(rating -> ratingService.deleteById(rating.getId()));

            // Eliminar el producto
            productoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
    }

    @Override
    public List<Producto> searchByKeyword(String keyword) {
        return productoRepository.findAll().stream()
                .filter(producto -> producto.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        producto.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                        producto.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}