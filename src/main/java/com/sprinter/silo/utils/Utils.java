package com.sprinter.silo.utils;

import com.sprinter.silo.config.excepcions.BadRequestException;
import com.sprinter.silo.models.Articulo;

public class Utils {

    /**
     * Función encargada de comprobar todos los atributos
     * de la entidad "articulo".
     * En el caso de que detecte algun dato erroneo, salta excepción informando.
     * @param articulo Recibe el artículo a chequear.
     */
    public static void comprobarArticulo(Articulo articulo){

        if(articulo.getEan() == null || articulo.getEan().isEmpty()){
            throw new BadRequestException("Ean inválido");
        }
        if(articulo.getNombre() == null || articulo.getNombre().isEmpty()){
            throw new BadRequestException("Nombre inválido");
        }
        if(articulo.getImporte() <= 0 || esNumero(""+articulo.getImporte())){
            throw new BadRequestException("Importe inválido");
        }
        if(articulo.getColor() == null || articulo.getColor().isEmpty()){
            throw new BadRequestException("Color inválido");
        }
        if(articulo.getTalla() == null || articulo.getTalla().isEmpty()){
            throw new BadRequestException("Talla inválida");
        }
    }

    /**
     * Función encargada de comprobar si elemento
     * es un número.
     * @param cadena Recibe cadena con el elemento a comprobar
     * @return devuelve true si es un número, o false en caso contrario.
     */
    public static boolean esNumero (String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
