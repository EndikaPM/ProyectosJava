package Mamifero.Canino;

public class Lobo extends Canino{
    private Integer numCamada;
    private String especieLobo;

    public Lobo() {}
    public Lobo(String habitat, Float altura, Float largo, Float peso, String nombre, String color, Float colmillo, Integer numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombre, color, colmillo);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    public Integer getNumCamada() {
        return numCamada;
    }

    public void setNumCamada(Integer numCamada) {
        this.numCamada = numCamada;
    }

    public String getTamanioColmillo() {
        return especieLobo;
    }

    public void setTamanioColmillo(String especieLobo) {
        this.especieLobo = especieLobo;
    }

    @Override
    public String comer() {
        return "La Camada " + numCamada + " come de la presa que han cazada esta mañana.";
    }

    @Override
    public String dormir() {
        return "EL lobo duerme y deja ver sus " + especieLobo + " cm de colmillo";
    }

    @Override
    public String correr() {
        return "El lobo corre par no quedarse sin comida";
    }

    @Override
    public String comunicarse() {
        return "¡AaaaauuuuFFFFFuuuuuuuuu!";
    }

    @Override
    public String toString() {
        return "----------------\nLOBO  \n\t habitat: " + habitat + "\n\t altura: " + altura +
                "\n\t largo:" + largo+
                "\n\t peso:" + peso +
                "\n\t nombre: " + nombre+
                "\n\t color pelaje: "+ color+
                "\n\t tamaño colmillo: " + colmillo+
                "\n\t nº canada: " + numCamada+
                "\n\t especie: " + especieLobo;
    }
}
