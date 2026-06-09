package org.endika.ejemplo.respository;

import org.endika.ejemplo.model.Examen;

import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}
