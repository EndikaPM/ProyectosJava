package Mamifero.Felino;
import Mamifero.Mamifero;

abstract  public class Felino extends Mamifero {
    protected Float tamanioGarra;
    protected Integer velocidad;

    public Felino() {}
    public Felino(String habitat, Float altura, Float largo, Float peso, String nombre, Integer velocidad, Float tamanioGarra) {
        super(habitat, altura, largo, peso, nombre);
        this.velocidad = velocidad;
        this.tamanioGarra = tamanioGarra;
    }

    public int getValocidad() {
        return velocidad;
    }

    public void setValocidad(int valocidad) {
        this.velocidad = valocidad;
    }

    public float getTamanioGarra() {
        return tamanioGarra;
    }

    public void setTamanioGarra(Float tamanioGarra) {
        this.tamanioGarra = tamanioGarra;
    }

}
