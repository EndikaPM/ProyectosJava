package Mamifero.Canino;

public class Perro extends Canino{
    private Integer fuerzaMordida;

    public Perro() {}
    public Perro(String habitat, Float altura, Float largo, Float peso, String nombre, String color, Float colmillo, Integer fuerzaMordida) {
        super(habitat, altura, largo, peso, nombre, color, colmillo);
        this.fuerzaMordida = fuerzaMordida;
    }

    public Integer getFuerzaMordida() {
        return fuerzaMordida;
    }

    public void setFuerzaMordida(Integer fuerzaMordida) {
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "Los pelleos muerdes su comida con una fuerza de " + fuerzaMordida + " kg por m2";
    }

    @Override
    public String dormir() {
        return "los perros duermen por el dia para descansar ";
    }

    @Override
    public String correr() {
        return "Los perros corren por el parque felices";
    }

    @Override
    public String comunicarse() {
        return "¡Grrr! ¡Guau! ¡Grrr! ¡Guau!";
    }

    @Override
    public String toString() {
        return "----------------\nPERRO  \n\t habitat: " + habitat + "\n\t altura: " + altura +
                "\n\t largo: " + largo+
                "\n\t peso: " + peso +
                "\n\t nombre: " + nombre+
                "\n\t color pelaje: "+ color+
                "\n\t tamaño colmillo: " + colmillo+
                "\n\t mordida: " + fuerzaMordida;
    }
}
