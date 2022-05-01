package com.sprinter.silo.repository;

import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
