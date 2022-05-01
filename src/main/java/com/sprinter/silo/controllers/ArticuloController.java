package com.sprinter.silo.controllers;

import com.sprinter.silo.dtos.ArticuloDto;
import com.sprinter.silo.models.Articulo;
import com.sprinter.silo.service.ArticuloServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ArticuloController {

    @Autowired
    private ArticuloServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;

    //----------------------- Respuestas Añadir articulos ------------

    /**
     * Captura las peticiones que le llegan por metodo POST y con
     * direccion api/add. En la petición se envia un objeto artículo
     * y se llama a metodo de la interface de servicio de artículos addArticulos
     * que se encargará de insertarlo en la base de datos.
     * @param articulo recibe un objeto artículo.
     * @return devuelve un booleano true en el caso de que se inserte correctamente o
     * false en el caso de detectarse algun incidente.
     */
    @RequestMapping (value = "api/add", method = RequestMethod.POST)
    public Articulo addArticulo(@RequestBody Articulo articulo){
        return service.addArticulo(articulo);
    }

    //----------------------- Respuestas Listar articulos ------------


    /**
     * Captura las peticiones que le llegan por metodo GET con direccion
     * api/list. Se encarga de solicitar al servicio un lsitado con
     * todos los articulos y devolverlo.
     * @return Devuelve un listado con todos los artículos de la base de
     * datos o si no existe ninguno revuleve el listado sin inicializar.
     */
    @RequestMapping (value = "api/list", method = RequestMethod.GET)
    public List<ArticuloDto> mostrarArticulos(){
        //List<Articulo> articulos = service.listar();
        return service.listar().stream().map(articulo -> modelMapper.map(articulo,ArticuloDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Captura las peticiones que le llegan por metodo GET, con la
     * dirección api/listOne , por json. Posteriormente le solicita al repositorio
     * que busque un articulo con un id en concreto. En el caso de encontrarlo lo devuelve
     * como objeto Articulo. En caso contrario devuelve null.
     * @param articulo Objeto tipo articulo que indica el id del artículo a listar.
     * @return devuelve un objeto articulo.
     */

    @RequestMapping (value = "api/listOneJson", method = RequestMethod.GET)
    public Articulo findArticuloById(@RequestBody Articulo articulo){
        return service.findArticuloById(articulo.getId());
    }

    /**
     * Captura las peticiones que le llegan por metodo GET, con la
     * dirección api/listOne , por parametros. Posteriormente le solicita al repositorio
     * que busque un articulo con un id en concreto. En el caso de encontrarlo lo devuelve
     * como objeto Articulo. En caso contrario devuelve null.
     * @param idIn long que indica el id del artículo a listar.
     * @return devuelve un objeto articulo.
     */

    @RequestMapping (value = "api/listOne", method = RequestMethod.GET)
    public Articulo findArticuloById(@RequestParam(value = "id")int idIn){
        return service.findArticuloById(idIn);
    }



    //----------------------- Respuestas Actualizar articulos ------------

    /**
     * Funcion encargada de recibir una peticion PUT con direccion api/updateArticulo.
     * Solicita buscar ese artículo y si lo encuentra lo actualiza con los nuevos datos.
     * @param articulo nuevos datos para actualizar el artículo buscado.
     * @return devuelve un boolean true si todo ha ido bien o false en el
     * caso de que algo pase.
     */

    //Por json
    @RequestMapping (value = "api/updateArticulo", method = RequestMethod.PUT)
    public Articulo updateArticulo(@RequestBody Articulo articulo){
        return service.updateArticulo(articulo.getId(),articulo);
    }

    /**+
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

    //Por parametros
    @RequestMapping (value = "api/update", method = RequestMethod.PUT)
    public Articulo updateArticulo(
                            @RequestParam(value = "id")int idIn,
                            @RequestParam(value = "ean")String eanIn,
                            @RequestParam(value = "nombre")String nombreIn,
                            @RequestParam(value = "importe")Double importeIn,
                            @RequestParam(value = "talla")String tallaIn,
                            @RequestParam(value = "color")String colorIn
                            ){

        Articulo articulo = new Articulo(idIn,eanIn,nombreIn,importeIn,tallaIn,colorIn);
        return service.updateArticulo(idIn,articulo);
    }



    //----------------------- Respuestas Borrar articulos ------------

    /**+
     * Funcion encargada de recibir una peticion DELETE con direccion api/delete
     * y un json con los datos del artículo a eliminar.
     * Solicita buscar ese artículo y si lo encuentra lo borra.
     * @return Devuelve un booleano true en el caso de que se haya borrado correctamente
     * el artículo, o en su defecto false si se ha detectado alguna incidencia.
     */

    //Por Json
    @RequestMapping (value = "api/deleteArticulo", method = RequestMethod.DELETE)
    public void deleteArticulo(@RequestBody Articulo articulo){
        service.deleteArticulo(articulo.getId());
    }

    /**
     * Funcion encargada de recibir una peticion DELETE con direccion api/delete.
     * Solicita buscar ese artículo y si lo encuentra lo borra.
     * @param id identificador del articulo a buscar y eliminar.
     * @return Devuelve un booleano true en el caso de que se haya borrado correctamente
     * el artículo, o en su defecto false si se ha detectado alguna incidencia.
     */

    //Por parametros
    @RequestMapping (value = "api/delete", method = RequestMethod.DELETE)
    public void borrarArticulo(@RequestParam(value = "id")int id){
        service.deleteArticulo(id);
    }
}
