package Mamifero.Canino;
import Mamifero.Mamifero;
abstract public class Canino extends Mamifero {
    protected String color;
    protected Float colmillo;

    public Canino() {}
    public Canino(String habitat, Float altura, Float largo, Float peso, String nombre, String color, Float colmillo) {
        super(habitat, altura, largo, peso, nombre);
        this.color = color;
        this.colmillo = colmillo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getColmillo() {
        return colmillo;
    }

    public void setColmillo(Float colmillo) {
        this.colmillo = colmillo;
    }

}
