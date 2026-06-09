package org.endika.ejemplo.respository;

import java.util.List;

public interface PreguntaRepository {
    void guardarTodasPreguntas(List<String> preguntas);
    List<String> findPreguntasPorExamenId(Long id);
}
