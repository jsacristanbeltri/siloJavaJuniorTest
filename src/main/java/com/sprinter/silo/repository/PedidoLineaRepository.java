package com.sprinter.silo.repository;

import com.sprinter.silo.models.PedidoLinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoLineaRepository extends JpaRepository<PedidoLinea, Integer> {
}
