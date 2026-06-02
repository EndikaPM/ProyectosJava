import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private LocalDateTime fechaYhora;
    private  Integer canPasajeros;


    public Vuelo() {}
    public Vuelo(String nombre, String origen, String destino, String fechaYhora, Integer canPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        DateTimeFormatter formtoFechaHora = DateTimeFormatter.ofPattern("dd MM yyyy HH:mm");
        this.fechaYhora = LocalDateTime.parse(fechaYhora, formtoFechaHora);
        this.canPasajeros = canPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public  Integer getCanPasajeros() {
        return canPasajeros;
    }


    public void setCanPasajeros(Integer canPasajeros) {
        this.canPasajeros = canPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo: \n\t" + nombre +
                "\n\t  con origen = " + origen +
                ",  destino = " + destino +
                ", con  fecha de llegada = " + fechaYhora + " hrs.";
    }
}
