package com.sprinter.silo.config;

import com.sprinter.silo.config.excepcions.BadRequestException;
import com.sprinter.silo.config.excepcions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase encargada de controlar las excepciones.
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    /**
     * Metodo encargado de controlar las excepciones
     * del tipo NotFoundException.
     * @param e Recibe una excepcion
     * @return Devuelve un mensaje, en este caso
     * es el mismo mensaje de excepcion que recibe por
     * parametros
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    /**
     * Metodo encargado de controlar las excepciones
     * del tipo BadRequestException.
     * @param e Recibe una excepcion
     * @return Devuelve un mensaje, en este caso
     * es el mismo mensaje de excepcion que recibe por
     * parametros
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
