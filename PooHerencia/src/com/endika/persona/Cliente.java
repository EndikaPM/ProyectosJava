package com.endika.persona;

public class Cliente extends Persona{
    private int idCliente;

    public Cliente() {}
    public Cliente(String nombre, String apelliado, String numFical, String direccion, int idCliente){
        super(nombre, apelliado, numFical, direccion);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", idCliente= " + idCliente;
    }
}
