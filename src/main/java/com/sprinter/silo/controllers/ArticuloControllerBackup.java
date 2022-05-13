package com.sprinter.silo.controllers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.service.ArticuloServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ArticuloControllerBackup {

    @Autowired
    private ArticuloServiceImpl articuloService;



    //----------------------- Respuestas Añadir articulos ------------

    /**
     * Captura las peticiones que le llegan por metodo POST y con
     * direccion api/add. En la petición se envia un objeto artículo
     * y se llama a metodo de la interface de servicio de artículos addArticulos
     * que se encargará de insertarlo en la base de datos.
     * @param articuloDtoRequest recibe un objeto artículo.
     * @return devuelve un booleano true en el caso de que se inserte correctamente o
     * false en el caso de detectarse algun incidente.
     */
    @RequestMapping (value = "articulo/create", method = RequestMethod.POST)
    public ResponseEntity<ArticuloDto> addArticulo(@RequestBody ArticuloDto articuloDtoRequest){
    /*
        Articulo articulo = convertToEntity(articuloDtoRequest);
        Articulo articuloResultado = service.addArticulo(articulo);
        ArticuloDto articuloDtoResultado = convertToDto(articuloResultado);*/

        return ResponseEntity.ok().body(articuloService.create(articuloDtoRequest));
    }

    //----------------------- Respuestas Listar articulos ------------


    /**
     * Captura las peticiones que le llegan por metodo GET con direccion
     * api/list. Se encarga de solicitar al servicio un lsitado con
     * todos los articulos y devolverlo.
     * @return Devuelve un listado con todos los artículos de la base de
     * datos o si no existe ninguno revuleve el listado sin inicializar.
     */
    @RequestMapping (value = "articulo/findAll", method = RequestMethod.GET)
    public List<ArticuloDto> mostrarArticulos(){
        //List<Articulo> articulos = service.listar();
        /*return service.listar().stream().map(articulo -> modelMapper.map(articulo,ArticuloDto.class))
                .collect(Collectors.toList());*/
        return articuloService.findAll();
    }

    /**
     * Captura las peticiones que le llegan por metodo GET, con la
     * dirección api/listOne , por json. Posteriormente le solicita al repositorio
     * que busque un articulo con un id en concreto. En el caso de encontrarlo lo devuelve
     * como objeto Articulo. En caso contrario devuelve null.
     * @return devuelve un objeto articulo.
     */

    @RequestMapping (value = "articulo/findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArticuloDto> findArticuloById(final @PathVariable int id){
        /*Articulo articulo = service.findArticuloById(articuloDtoRequest.getId());

        //Convert entity to DTO
        ArticuloDto articuloDtoResponse = convertToDto(articulo);
        //ArticuloDto articuloDtoResponse = modelMapper.map(articulo,ArticuloDto.class);*/
        return ResponseEntity.ok().body(articuloService.findById(id));
    }

    /**
     * Captura las peticiones que le llegan por metodo GET, con la
     * dirección api/listOne , por parametros. Posteriormente le solicita al repositorio
     * que busque un articulo con un id en concreto. En el caso de encontrarlo lo devuelve
     * como objeto Articulo. En caso contrario devuelve null.
     * @param id long que indica el id del artículo a listar.
     * @return devuelve un objeto articulo.
     */


    @RequestMapping (value = "articulo/findById", method = RequestMethod.GET)
    public ResponseEntity<ArticuloDto> findArticuloByIdParam(@RequestParam(value = "id")int id){
/*
        Articulo articulo = service.findArticuloById(idIn);

        //Convert entity to DTO
        //ArticuloDto articuloDtoResponse = modelMapper.map(articulo,ArticuloDto.class);
        ArticuloDto articuloDtoResponse = convertToDto(articulo);*/

        return ResponseEntity.ok().body(articuloService.findById(id));
    }



    //----------------------- Respuestas Actualizar articulos ------------

    /**
     * Funcion encargada de recibir una peticion PUT con direccion api/updateArticulo.
     * Solicita buscar ese artículo y si lo encuentra lo actualiza con los nuevos datos.
     * @param articuloDtoRequest nuevos datos para actualizar el artículo buscado.
     * @return devuelve un boolean true si todo ha ido bien o false en el
     * caso de que algo pase.
     */

    //Por json
    @RequestMapping (value = "articulo/updateArticulo", method = RequestMethod.PUT)
    public ResponseEntity<ArticuloDto> updateArticulo(@RequestBody ArticuloDto articuloDtoRequest){
/*
        //Convert DTO to entity
        Articulo articuloRequest = convertToEntity(articuloDtoRequest);
        //Articulo articuloRequest = modelMapper.map(articuloDtoRequest,Articulo.class);

        //Update
        Articulo articuloUpdatedDto = service.updateArticulo(articuloRequest.getId(),articuloRequest);

        //Convert entity to DTO
        ArticuloDto articuloDto = convertToDto(articuloUpdatedDto);
        //ArticuloDto articuloDto = modelMapper.map(articuloUpdatedDto,ArticuloDto.class);*/

        return ResponseEntity.ok().body(articuloService.update(articuloDtoRequest.getId(),articuloDtoRequest));
    }


    /**
     * Funcion que recibe por parametros todos los datos de un articulo
     * , localiza un articulo en base de datos igual y lo actualiza.
     * @param idIn id del articulo a actualizar.
     * @param eanIn Nuevo ean para el nuevo artículo.
     * @param nombreIn Nuevo nombre para el nuevo artículo.
     * @param importeIn Nuevo importe para el nuevo artículo.
     * @param tallaIn Nueva talla para el nuevo artículo.
     * @param colorIn Nuevo color para el nuevo artículo.
     * @return
     */
/*
    //Por parametros
    @RequestMapping (value = "api/update", method = RequestMethod.PUT)
    public ResponseEntity<ArticuloDto> updateArticulo(
                            @RequestParam(value = "id")int idIn,
                            @RequestParam(value = "ean")String eanIn,
                            @RequestParam(value = "nombre")String nombreIn,
                            @RequestParam(value = "importe")Double importeIn,
                            @RequestParam(value = "talla")String tallaIn,
                            @RequestParam(value = "color")String colorIn
                            ){

        Articulo articuloRequest = new Articulo(idIn,eanIn,nombreIn,importeIn,tallaIn,colorIn);


        //Update
        Articulo articuloUpdatedDto = service.updateArticulo(articuloRequest.getId(),articuloRequest);

        //Convert entity to DTO
        ArticuloDto articuloDto = convertToDto(articuloUpdatedDto);
        //ArticuloDto articuloDto = modelMapper.map(articuloUpdatedDto,ArticuloDto.class);


        return ResponseEntity.ok().body(articuloService.update(articuloRequest.getId(),));
    }*/



    //----------------------- Respuestas Borrar articulos ------------

    /**+
     * Funcion encargada de recibir una peticion DELETE con direccion api/delete
     * y un json con los datos del artículo a eliminar.
     * Solicita buscar ese artículo y si lo encuentra lo borra.
     */

    //Por Json
    @RequestMapping (value = "articulo/deleteArticulo/{id}", method = RequestMethod.DELETE)
    public void deleteArticulo (final @PathVariable int id){
        /*Articulo articulo = convertToEntity(articuloDtoRequest);
        service.deleteArticulo(articulo.getId());*/
        articuloService.delete(id);
    }

    /**
     * Funcion encargada de recibir una peticion DELETE con direccion api/delete.
     * Solicita buscar ese artículo y si lo encuentra lo borra.
     * @param id identificador del articulo a buscar y eliminar.
     * @return Devuelve un booleano true en el caso de que se haya borrado correctamente
     * el artículo, o en su defecto false si se ha detectado alguna incidencia.
     */

    //Por parametros
    @RequestMapping (value = "articulo/delete", method = RequestMethod.DELETE)
    public void borrarArticulo(@RequestParam(value = "id")int id){
        //service.deleteArticulo(id);
        articuloService.delete(id);
    }


}




