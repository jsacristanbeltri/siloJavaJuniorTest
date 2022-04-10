package com.sprinter.silo.service;

import com.sprinter.silo.models.Articulo;

import java.util.List;

/**
 * Interfaz del servicio de Articulo.
 */
public interface IArticuloService {
    public boolean addArticulo(Articulo articulo);
    public List<Articulo> listar();
    public Articulo listarArticuloId(int id);
    public boolean editarArticulo(Articulo articulo);
    public boolean eliminarArticulo (int id);
}
