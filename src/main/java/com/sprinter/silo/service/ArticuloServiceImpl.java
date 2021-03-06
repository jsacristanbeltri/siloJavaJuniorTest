package com.sprinter.silo.service;

import com.sprinter.silo.config.excepcions.NotFoundException;
import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.mappers.ArticuloMapper;
import com.sprinter.silo.mappers.SiloMapper;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.repository.ArticuloRepository;
import com.sprinter.silo.utils.Utils;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicios de artículo.
 */
@Service
@Slf4j
public class ArticuloServiceImpl extends AbstractSiloService<Articulo, ArticuloDto> implements ArticuloService
{

    /*@Autowired
    private final ArticuloRepository articuloRepository;*/

    //protected final SiloMapper<Articulo,ArticuloDto> mapper;
    //protected final SiloMapper mapper;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository repository, ArticuloMapper mapper) {
        super(repository, mapper);
    }



    /**
     * Función encargada de recibir un artículo y
     * llamar a la funcion del repositorio (dao) para
     * realizar la inserción en base de datos.
     * @param articuloRequest objeto artículo para insertar en db.
     * @return devuelve un booleano true si ha ido correcto
     * y false si ha fallado algo.
     */

    @Override
    public ArticuloDto create(ArticuloDto articuloRequest) {
       /* log.info("entra en create");
        Articulo articulo = mapper.toEntity(articuloRequest);
        log.info("mapea ok");
        //Utils.comprobarArticulo(articulo);*/

        return mapper.toDto(repository.save(mapper.toEntity(articuloRequest)));
    }

    /**
     * Función encargada de devolver una lista
     * con todos los artículos de la base de datos.
     * @return Lista con todos los artículos de la
     * base de datos. En el caso de que no existan artículos
     * saltará una excepcion indicando que no hay artículos
     * en la base de datos.
     */


    /**
     * Función encargada de buscar un artículo en la base
     * de datos a partir de su id.
     * @param id Recibe el id del artículo a busca.
     * @return Devuelve un articulo, si existe. En el caso de
     * que no lo encuentre, salta una excepción.
     */



    /**
     * Función encargada de editar un artículo
     * existente en la base de datos.
     * @param id identificador del articulo a actualziar
     * @param articuloDtoRequest recibe un objeto articulo que en el
     * caso de que exista en la base de datos, sustituirá
     * el objeto artículo de la base de datos.
     * @return Devuelve el articulo actualizado
     */

    @Override
    public ArticuloDto update(int id, ArticuloDto articuloDtoRequest) {
        Optional<Articulo> articuloResponse = repository.findById(id);
        Articulo articulo = articuloResponse.get();
        /*Utils.comprobarArticulo(articulo);
        if(articulo==null)
            throw new NotFoundException("Artículo no existe.");

        if(Objects.nonNull(articuloDtoRequest.getEan())
            && !"".equalsIgnoreCase(articuloDtoRequest.getEan())
        ){
            articulo.setEan(articuloDtoRequest.getEan());
        }

        if(Objects.nonNull(articuloDtoRequest.getNombre())
                && !"".equalsIgnoreCase(articuloDtoRequest.getNombre())
        ){
            articulo.setNombre(articuloDtoRequest.getNombre());
        }

        if(Objects.nonNull(articuloDtoRequest.getImporte())
                && articuloDtoRequest.getImporte()>=0
        ){
            articulo.setImporte(articuloDtoRequest.getImporte());
        }*/

        return mapper.toDto(repository.save(mapper.toEntity(articuloDtoRequest)));
    }

    /**
     * Función encargada de buscar en la base de datos
     * un artículo con un id en concreto y eliminarlo.
     * @param id Recibe el id del artículo a borrar
     */




    /*private ArticuloDto convertToDto (Articulo articuloRequest){
        ArticuloDto articuloDto = modelMapper.map(articuloRequest,ArticuloDto.class);
        return articuloDto;
    }

    private Articulo convertToEntity (ArticuloDto articuloDtoRequest){
        Articulo articulo = modelMapper.map(articuloDtoRequest,Articulo.class);
        return articulo;
    }*/

}


