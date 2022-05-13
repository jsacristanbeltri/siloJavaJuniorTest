package com.sprinter.silo.service;

import com.sprinter.silo.models.Pedido;

import java.util.List;

public interface PedidoService {
    public Pedido addPedido(Pedido pedido);
    public List<Pedido> listarPedidos();
    public Pedido getPedidoById(int id);
    public Pedido updatePedido(int id, Pedido pedido);
    public void deletePedido ();
}
