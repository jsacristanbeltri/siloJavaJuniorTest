package com.sprinter.silo.service;

import com.sprinter.silo.models.Pedido;
import com.sprinter.silo.repository.PedidoRepository;
import com.sprinter.silo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido addPedido(Pedido pedido) {
        return null;
    }

    @Override
    public List<Pedido> listarPedidos() {
        return null;
    }

    @Override
    public Pedido getPedidoById(int id) {
        return null;
    }

    @Override
    public Pedido updatePedido(int id, Pedido pedido) {
        return null;
    }

    @Override
    public void deletePedido() {

    }
}
