package org.endika.ejemplo.service;

import org.endika.ejemplo.model.Examen;
import org.endika.ejemplo.respository.ExamenRepository;
import org.endika.ejemplo.respository.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {
//Son dos mack y un service
    @Mock
    ExamenRepository repository;
    @Mock
    PreguntaRepository preguntaRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @BeforeEach
    void setUp() {
       /* MockitoAnnotations.openMocks(this); la primera lina es lo mismo que las tres de abajo pero tambien se puede
        preguntaRepository = mock(PreguntaRepository.class); la anotacion @ExtendWith(MockitoExtension.class)
        repository = mock(ExamenRepository.class); distintas maneras de Inyeccion de dependecias
        service = new ExamenServiceImpl(repository, preguntaRepository);*/
    }

    @Test
    void findExameByNombre() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        Optional<Examen> examen = service.findExameByNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());// se puede con get.get... lo que sea pero recomiendan orElseThrow
        assertEquals("Matematicas", examen.get().getNombre());// aqui lo pongo para que acordame como se hace
    }

    @Test
    void findExameByNombreEmpy() {
        List<Examen> datos = Collections.emptyList();

        when(repository.findAll()).thenReturn(datos);

        Optional<Examen> examen = service.findExameByNombre("Matematicas");

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        //when(preguntaRepository.findPreguntasPorExamenId(5L)).thenReturn(Datos.PREGUNTAS);
        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);// cualquier valor Long menos especifico

         Examen examen = service.FiendExamenPorNombreConPreguntas("Matematicas");

         assertEquals(5, examen.getPreguntas().size());
    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.FiendExamenPorNombreConPreguntas("Matematicas");

        assertEquals(5, examen.getPreguntas().size());

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());
    }

    @Test
    void testNoExisteExamenVerify() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        when(preguntaRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.FiendExamenPorNombreConPreguntas("Matematicas2");

        assertNull(examen);

        verify(repository).findAll();
        verify(preguntaRepository).findPreguntasPorExamenId(anyLong());
    }

    @Test
    void guardarExamenTest() {
        // Given son las precondiciones en el entorno de prueba DADO
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        when(repository.guardar(any(Examen.class))).then(new Answer<Examen>(){

            Long secuencia = 8L;

            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });

        //When cuando  ejecutamos el metodo
        Examen examen = service.guardar(newExamen);

        // Then entonces validamos
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("Fisica", examen.getNombre());

        verify(repository).guardar(any(Examen.class));
        verify(preguntaRepository).guardarTodasPreguntas(anyList());
    }

}