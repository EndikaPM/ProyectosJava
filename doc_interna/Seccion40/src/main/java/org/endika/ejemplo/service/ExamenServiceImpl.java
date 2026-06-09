package org.endika.ejemplo.service;

import org.endika.ejemplo.model.Examen;
import org.endika.ejemplo.respository.ExamenRepository;
import org.endika.ejemplo.respository.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExameByNombre(String nombre) {

        return examenRepository.findAll().stream()
                .filter(examen -> examen.getNombre().equals(nombre))
                .findFirst();

    }

    @Override
    public Examen FiendExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExameByNombre(nombre);
        Examen examen = null;
        if (examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {
        if (!examen.getPreguntas().isEmpty()) preguntaRepository.guardarTodasPreguntas(examen.getPreguntas());
        return examenRepository.guardar(examen);
    }
}
