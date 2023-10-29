package com.example.dwwii_cl2_diaz.repository;


import com.example.dwwii_cl2_diaz.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> findProductosBetween10And100();

    @Query(nativeQuery = true, value = "SELECT * FROM Producto p WHERE YEAR(p.fecha_vencimiento) = 2024")
    List<Producto> findProductosWith2024Expiration();


}

