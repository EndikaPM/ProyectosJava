package Mamifero.Felino;

public class Tigre extends Felino{
    private String especiTigre;

    public Tigre() {}
    public Tigre(String habitat, Float altura, Float largo, Float peso, String nombre, Integer velocidad, Float tamanioGarra, String especiTigre) {
        super(habitat, altura, largo, peso, nombre, velocidad, tamanioGarra);
        this.especiTigre = especiTigre;
    }

    @Override
    public String comer() {
        return "El tigre come la caza del dia";
    }

    @Override
    public String dormir() {
        return "GZzzZZzZzZZzZzZzZ";
    }

    @Override
    public String correr() {
        return "El tigre " + especiTigre + " corre y salta por la selva";
    }

    @Override
    public String comunicarse() {
        return "¡Raaaargh!";
    }

    @Override
    public String toString() {
        return "----------------\nTIGRE  \n\t habitat: " + habitat + "\n\t altura:" + altura +
                "\n\t largo: " + largo+
                "\n\t peso: " + peso +
                "\n\t nombre: " + nombre+
                "\n\t velocidad: " + velocidad+
                "\n\t tamaño garra: " + tamanioGarra+
                "\n\t especie: " + especiTigre;
    }
}
