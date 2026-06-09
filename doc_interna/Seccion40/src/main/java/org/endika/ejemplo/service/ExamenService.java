package org.endika.ejemplo.service;

import org.endika.ejemplo.model.Examen;

import java.util.Optional;

public interface ExamenService {
    Optional<Examen> findExameByNombre(String nombre);
    Examen FiendExamenPorNombreConPreguntas(String nombre);
    Examen guardar(Examen examen);
}
