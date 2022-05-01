package com.sprinter.silo.service;

import com.sprinter.silo.config.excepcions.NotFoundException;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.repository.ArticuloRepository;
import com.sprinter.silo.utils.Utils;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicios de artículo.
 */
@Service
@RequiredArgsConstructor
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private final ArticuloRepository articuloRepository;

    /**
     * Función encargada de recibir un artículo y
     * llamar a la funcion del repositorio (dao) para
     * realizar la inserción en base de datos.
     * @param articulo objeto artículo para insertar en db.
     * @return devuelve un booleano true si ha ido correcto
     * y false si ha fallado algo.
     */

    @Override
    public Articulo addArticulo(Articulo articulo) {
        Utils.comprobarArticulo(articulo);
        return articuloRepository.save(articulo);
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
        List<Articulo> articulos = articuloRepository.findAll();
        if(articulos.isEmpty())
            throw new NotFoundException("No existen artículos en la base de datos");
        return articulos;
    }

    /**
     * Función encargada de buscar un artículo en la base
     * de datos a partir de su id.
     * @param id Recibe el id del artículo a busca.
     * @return Devuelve un articulo, si existe. En el caso de
     * que no lo encuentre, salta una excepción.
     */

    @Override
    public Articulo findArticuloById(int id) {
        if(Utils.esNumero(""+id)){
            Optional<Articulo> articuloResponse = articuloRepository.findById(id);
            Articulo articulo = articuloResponse.get();

            return articulo;
        }
        else
            return null;

    }

    /**
     * Función encargada de editar un artículo
     * existente en la base de datos.
     * @param articuloRequest recibe un objeto articulo que en el
     * caso de que exista en la base de datos, sustituirá
     * el objeto artículo de la base de datos.
     * @return Devuelve el articulo actualizado
     */

    @Override
    public Articulo updateArticulo(int id,Articulo articuloRequest) {
        Utils.comprobarArticulo(articuloRequest);
        Optional<Articulo> articuloResponse = articuloRepository.findById(id);
        Articulo articulo = articuloResponse.get();
        if(articulo==null)
            throw new NotFoundException("Artículo no existe.");

        if(Objects.nonNull(articuloRequest.getEan())
            && !"".equalsIgnoreCase(articuloRequest.getEan())
        ){
            articulo.setEan(articuloRequest.getEan());
        }

        if(Objects.nonNull(articuloRequest.getNombre())
                && !"".equalsIgnoreCase(articuloRequest.getNombre())
        ){
            articulo.setNombre(articuloRequest.getNombre());
        }

        if(Objects.nonNull(articuloRequest.getImporte())
                && articuloRequest.getImporte()>=0
        ){
            articulo.setImporte(articuloRequest.getImporte());
        }

        if(Objects.nonNull(articuloRequest.getTalla())
                && !"".equalsIgnoreCase(articuloRequest.getTalla())
        ){
            articulo.setTalla(articuloRequest.getTalla());
        }
        if(Objects.nonNull(articuloRequest.getColor())
                && !"".equalsIgnoreCase(articuloRequest.getColor())
        ){
            articulo.setColor(articuloRequest.getColor());
        }

        return articuloRepository.save(articulo);
    }

    /**
     * Función encargada de buscar en la base de datos
     * un artículo con un id en concreto y eliminarlo.
     * @param id Recibe el id del artículo a borrar
     */

    @Override
    public void deleteArticulo(int id) {
        articuloRepository.deleteById(id);
    }





}


