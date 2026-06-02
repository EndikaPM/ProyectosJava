package org.endika.anotaciones.procesador;

import org.endika.anotaciones.ejemplo.JsonArtributo;
import org.endika.anotaciones.procesador.exception.JsonSerializadorExcepcion;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class JsonSerializador {

    public static String convertirJson(Object object){

        //if (object == null){
        if (Objects.isNull(object)){
            throw new JsonSerializadorExcepcion ("El objeto " + object.getClass() + " sesializar no puede ser null ");
        }
        Field[] campos = object.getClass().getDeclaredFields();
        return Arrays.stream(campos).filter(f->f.isAnnotationPresent(JsonArtributo.class))
                .map(f->{
                    f.setAccessible(true);
                    String nombre = f.getAnnotation(JsonArtributo.class).nombre().
                            equals("")?f.getName():f.getAnnotation(JsonArtributo.class).nombre();
                    try {
                        Object valor = f.get(object);
                        if (f.getAnnotation(JsonArtributo.class).capitalizar()&&
                        valor instanceof String){
                            String nuevoValor = (String) valor;
                            nuevoValor = String.valueOf(nuevoValor.charAt(0)).toUpperCase() +
                                    nuevoValor.substring(1).toLowerCase();
                            f.set(object, nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + f.get(object) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorExcepcion ("Error al serializar el JSON " + e.getMessage());
                    }
                }).reduce("{", (a,b) ->{
                    if ("{".equals(a)){
                        return a + b;
                    }else {
                        return a + ", "+ b;
                    }
                }).concat("}");
    }
}
