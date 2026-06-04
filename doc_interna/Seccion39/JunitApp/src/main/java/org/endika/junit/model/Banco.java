package org.endika.junit.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;
    private String name;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta){
        this.cuentas.add(cuenta);
        cuenta.setBanco(this);
    }

    public void transferir (Cuenta origen, Cuenta destino, BigDecimal cantidad){
        origen.debito(cantidad);
        destino.credito(cantidad);
    }
}
