package com.sprinter.silo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="pedidos")
public class Pedido implements SiloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "pedidolinea_id")
    private List<PedidoLinea> lineasPedido;
}
