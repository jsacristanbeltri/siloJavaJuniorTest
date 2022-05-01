package com.sprinter.silo.service;

import com.sprinter.silo.models.Articulo;

import java.util.List;

/**
 * Interfaz del servicio de Articulo.
 */
public interface ArticuloService {
    public Articulo addArticulo(Articulo articulo);
    public List<Articulo> listar();
    public Articulo findArticuloById(int id);
    public Articulo updateArticulo(int id,Articulo articulo);
    public void deleteArticulo (int id);
}
