package com.endika.persona;

public class Empleado extends Persona{
    private double remuneracion;
    private int idEmpleado;

    public Empleado(){}
    public Empleado(String nombre, String apellido, String numFiscal, String direccion, double remuneracion, int idEmpleado){
        super(nombre, apellido, numFiscal, direccion);
        this.remuneracion = remuneracion;
        this.idEmpleado = idEmpleado;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void aumentarRemuneracion ( int porcentaje){
        double porAumento = (this.remuneracion * porcentaje)/ 100;
        this.remuneracion = remuneracion + porAumento;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", idEmpleado= " + idEmpleado +
                ", remuneracion= " + remuneracion + " €";
    }
}
