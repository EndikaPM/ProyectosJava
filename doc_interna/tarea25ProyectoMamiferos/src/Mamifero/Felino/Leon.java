package Mamifero.Felino;


public class Leon extends Felino {
    private Integer numMAnada;
    private Float potenciaRugidoDecibelios;

    public Leon() {}
    public Leon(String habitat, Float altura, Float largo, Float peso, String nombre, Integer velocidad, Float tamanioGarra, Integer numMAnada, Float potenciaRugidoDecibelios) {
        super(habitat, altura, largo, peso, nombre, velocidad, tamanioGarra);
        this.numMAnada = numMAnada;
        this.potenciaRugidoDecibelios = potenciaRugidoDecibelios;
    }

    public Integer getNumMAnada() {
        return numMAnada;
    }

    public void setNumMAnada(Integer numMAnada) {
        this.numMAnada = numMAnada;
    }

    public float getPotenciaRugidoDecibelios() {
        return potenciaRugidoDecibelios;
    }

    public void setPotenciaRugidoDecibelios(Float potenciaRugidoDecibelios) {
        this.potenciaRugidoDecibelios = potenciaRugidoDecibelios;
    }

    @Override
    public String comer() {
        return "El leon caza junto a su grupo de " + numMAnada + " animales en la sabana Africana";
    }

    @Override
    public String dormir() {
        return "Leon: Grrrr zzzzzzzZZZ";
    }

    @Override
    public String correr() {
        return "El leon corre por la sabana.";
    }

    @Override
    public String comunicarse() {
        return "Leon: GRRROAR!!";
    }

    @Override
    public String toString() {
        return "----------------\nLEON  \n\t habitat: " + habitat + "\n\t altura: " + altura +
                "\n\t largo: " + largo+
                "\n\t peso: " + peso +
                "\n\t nombre: " + nombre+
                "\n\t velocidad: "+ velocidad+
                "\n\t tamaño garra:" + tamanioGarra+
                "\n\t nº manada: " + numMAnada+
                "\n\t rugido: "+ potenciaRugidoDecibelios +" decibelios";
    }
}
