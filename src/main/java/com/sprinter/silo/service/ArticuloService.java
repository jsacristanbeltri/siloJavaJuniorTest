package com.sprinter.silo.service;

import com.sprinter.silo.config.excepcions.NotFoundException;
import com.sprinter.silo.dao.ArticuloDao;
import com.sprinter.silo.dao.IArticulo;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios de artículo.
 */
@Service
public class ArticuloService implements IArticuloService {



    @Autowired
    private IArticulo dao = new ArticuloDao();

    /**
     * Función encargada de recibir un artículo y
     * llamar a la funcion del repositorio (dao) para
     * realizar la inserción en base de datos.
     * @param articulo objeto artículo para insertar en db.
     * @return devuelve un booleano true si ha ido correcto
     * y false si ha fallado algo.
     */
    @Override
    public boolean addArticulo(Articulo articulo) {
        Utils.comprobarArticulo(articulo);
        return dao.addArticulo(articulo);
    }

    /**
     * Función encargada de devolver una lista
     * con todos los artículos de la base de datos.
     * @return Lista con todos los artículos de la
     * base de datos. En el caso de que no existan artículos
     * saltará una excepcion indicando que no hay artículos
     * en la base de datos.
     */
    @Override
    public List<Articulo> listar() {
        List<Articulo> articulos = dao.listar();
        if(articulos.isEmpty())
            throw new NotFoundException("No existen artículos en la base de datos");
        return dao.listar();
    }

    /**
     * Función encargada de buscar un artículo en la base
     * de datos a partir de su id.
     * @param id Recibe el id del artículo a busca.
     * @return Devuelve un articulo, si existe. En el caso de
     * que no lo encuentre, salta una excepción.
     */
    @Override
    public Articulo listarArticuloId(int id) {
        if(Utils.esNumero(""+id)){
            Articulo articulo = dao.listarArticuloId(id);
            if(articulo==null)
                throw new NotFoundException("Artículo no existe.");
            else
                return articulo;
        }
        else
            return null;

    }

    /**
     * Función encargada de editar un artículo
     * existente en la base de datos.
     * @param articulo recibe un objeto articulo que en el
     * caso de que exista en la base de datos, sustituirá
     * el objeto artículo de la base de datos.
     * @return Devuelve booleando true si lo encuentra y lo actualiza
     * o salta exceción de artículo no encontrado.
     */
    @Override
    public boolean editarArticulo(Articulo articulo) {
        Utils.comprobarArticulo(articulo);
        if(!dao.editarArticulo(articulo))
            throw new NotFoundException("Artículo no existe.");
        else
        return true;
    }

    /**
     * Función encargada de buscar en la base de datos
     * un artículo con un id en concreto y eliminarlo.
     * @param id Recibe el id del artículo a borrar
     * @return Devueve true si se elimina correctamente.
     * En su defecto salta excepción de artículo no existente.
     */
    @Override
    public boolean eliminarArticulo(int id) {
        if(!dao.eliminarArticulo(id))
            throw new NotFoundException("Artículo no existe.");
        else
            return true;
    }



}


