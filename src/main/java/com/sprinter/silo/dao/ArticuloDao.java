package com.sprinter.silo.dao;

import com.sprinter.silo.models.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ArticuloDao implements IArticulo {

    @Autowired
    private JdbcTemplate template = new JdbcTemplate();

    /**
     * Función encargada de recibir un artículo y
     * insertarlo en la base de datos.
     * @param articulo objeto artículo para insertar en db.
     * @return devuelve un booleano true si ha ido correcto
     * y false si ha fallado algo.
     */
    @Override
    public boolean addArticulo(Articulo articulo) {
        String sql = "insert into articulos(ean,nombre,importe,talla,color)values (?,?,?,?,?)";
        if (articulo != null) {
            int response = template.update(sql,
                    articulo.getEan(),
                    articulo.getNombre(),
                    articulo.getImporte(),
                    articulo.getTalla(),
                    articulo.getColor());
            return response==1;
        }
        else
            return false;

    }

    /**
     * Función encargada de devolver una lista
     * con todos los artículos de la base de datos.
     * @return Lista con todos los artículos de la
     * base de datos. En el caso de que no existan artículos
     * devolverá una lista en estado null.
     */
    @Override
    public List<Articulo> listar() {
        String sql = "select * from articulos";
        List<Articulo> articulos = template.query(sql,new BeanPropertyRowMapper<Articulo>(Articulo.class));
        return articulos;
    }

    /**
     * Función encargada de buscar un artículo en la base
     * de datos a partir de su id.
     * @param id Recibe el id del artículo a busca.
     * @return Devuelve un articulo, si existe. En el caso de
     * que no lo encuentre, devuelve null.
     */
    @Override
    public Articulo listarArticuloId(int id) {
        String sql = "select * from articulos where id=?";
        List<Articulo> articulos = template.query(sql,new Object[]{id},new BeanPropertyRowMapper<Articulo>(Articulo.class));
        if(articulos.isEmpty())
            return null;
        else
            return articulos.get(0);
    }

    /**
     * Función encargada de editar un artículo
     * existente en la base de datos.
     * @param articulo recibe un objeto articulo que en el
     * caso de que exista en la base de datos, sustituirá
     * el objeto artículo de la base de datos.
     * @return Devuelve booleando true si lo encuentra y lo actualiza
     * o false si el artículo no es encontrado.
     */
    @Override
    public boolean editarArticulo(Articulo articulo) {
        String sql = "update articulos set ean=?,nombre=?,importe=?,talla=?,color=? where id=?";
        int response= template.update(sql,
                articulo.getEan(),
                articulo.getNombre(),
                articulo.getImporte(),
                articulo.getTalla(),
                articulo.getColor(),
                articulo.getId());
        return response==1;
    }

    /**
     * Función encargada de buscar en la base de datos
     * un artículo con un id en concreto y eliminarlo.
     * @param id Recibe el id del artículo a borrar
     * @return Devueve true si se elimina correctamente.
     * En su defecto devuelve false.
     */
    @Override
    public boolean eliminarArticulo(int id) {
        String sql = "delete from articulos where id=?";
        Object[] args = new Object[]{id};
        return template.update(sql, args)==1;
    }

}
