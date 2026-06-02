package org.endika.anotaciones.ejemplo;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)// donde se aplica este es sobre atributos
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonArtributo {
    String nombre () default  "";
    boolean capitalizar ()default false;
}
