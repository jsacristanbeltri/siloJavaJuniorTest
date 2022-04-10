package com.sprinter.silo.dao;

import com.sprinter.silo.models.Articulo;

import java.util.List;

/**
 * Interface de repositorio articulos.
 */
public interface IArticulo {
    public boolean addArticulo(Articulo articulo);
    public List<Articulo> listar();
    public Articulo listarArticuloId(int id);
    public boolean editarArticulo(Articulo articulo);
    public boolean eliminarArticulo (int id);
}
