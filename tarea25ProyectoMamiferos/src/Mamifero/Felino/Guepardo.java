package Mamifero.Felino;

public class Guepardo extends  Felino{
    public Guepardo() {
    }
    public Guepardo(String habitat, Float altura, Float largo, Float peso, String nombre, Integer velocidad, Float tamanioGarra) {
        super(habitat, altura, largo, peso, nombre, velocidad, tamanioGarra);
    }

    @Override
    public String comer() {
        return "El guepardo se come a la Gacela desprevenida";
    }

    @Override
    public String dormir() {
        return "ZZZZZ zzzzzzzz ZZZZZZZZ zzzz";
    }

    @Override
    public String correr() {
        return "El guepardo corre entre en la sabana";
    }

    @Override
    public String comunicarse() {
        return "¡Grrrrowl!";
    }

    @Override
    public String toString() {
        return "----------------\nGUEPARDO  \n\t habitat: " + habitat + "\n\t altura: " + altura +
                "\n\t largo: " + largo+
                "\n\t peso: " + peso +
                "\n\t nombre: " + nombre+
                "\n\t velocidad: "+ velocidad+
                "\n\t tamaño Garra: " + tamanioGarra;
    }
}
