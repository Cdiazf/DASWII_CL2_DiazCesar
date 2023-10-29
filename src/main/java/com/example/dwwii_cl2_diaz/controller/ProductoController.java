package com.example.dwwii_cl2_diaz.controller;


import com.example.dwwii_cl2_diaz.entity.Producto;
import com.example.dwwii_cl2_diaz.repository.ProductoRepository;
import com.example.dwwii_cl2_diaz.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @GetMapping("/cantidad-between")
    public List<Producto> buscarProductosEntre10y100() {
        return productoRepository.findProductosBetween10And100();
    }

    @GetMapping("/vencimiento-2024")
    public List<Producto> buscarProductosConVencimiento2024() {
        return productoRepository.findProductosWith2024Expiration();
    }


}
