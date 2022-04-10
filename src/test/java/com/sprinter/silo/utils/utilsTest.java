package com.sprinter.silo.utils;

import com.sprinter.silo.config.excepcions.BadRequestException;
import com.sprinter.silo.models.Articulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class utilsTest {

    @Autowired
    private Utils utils;

    @Test
    void comprobarArticulo() {
        Throwable exception = assertThrows(
                BadRequestException.class,
                () -> {
                    throw new BadRequestException("Request incorrecto");
                }
        );
        assertEquals("Request incorrecto", exception.getMessage());
    }

    @Test
    void esNumero() {
        Assertions.assertEquals(true,utils.esNumero("100"));
    }
}