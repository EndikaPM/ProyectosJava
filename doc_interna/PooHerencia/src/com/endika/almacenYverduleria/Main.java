package com.endika.almacenYverduleria;

public class Main {
    public static void main(String[] args) {
        Producto pr []= new Producto[8];
        pr[0] = new Lacteo("Yogur", 2.5, 10, 20);
        pr[1] = new Lacteo("Queso", 14.8, 4, 30);
        pr[2] = new Fruta("Melon", 12.6, 9, "Verde");
        pr[3] = new Fruta("Sandia", 9.1, 5, "Rojo");
        pr[4] = new Limpieza("Quitagrasas", 7.3,"Hidróxido de sodio" , 0.75);
        pr[5] = new Limpieza("Limpiacristales", 6.15, "Isopropanol", 0.75);
        pr[6] = new NoPerecedero("Miel", 10, 2, 5);
        pr[7] = new NoPerecedero("Leche en polvo", 20, 4, 9);
        for (Producto pro: pr){
            System.out.println(pro.toString());
        }
    }
}
