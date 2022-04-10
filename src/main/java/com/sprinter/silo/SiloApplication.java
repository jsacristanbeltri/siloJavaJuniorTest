package com.sprinter.silo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *El programa SiloApplication es una aplicacion
 * con arquitectura basada en servicios web REST.
 * Esta diseñada para responder y gestionar peticiones
 * de artículos, como puede ser crear artículos, borrar,
 * actualizar o listar.
 * Tambien cuenta con:
 * - base de datos en memoria (h2).
 * - Gestion de Excepciones
 *
 * @Author Jorge Sacristan Beltri
 * @version 1.0
 * @since 09/04/2022
 */

@Slf4j
@SpringBootApplication
public class SiloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiloApplication.class, args);
	}

}
