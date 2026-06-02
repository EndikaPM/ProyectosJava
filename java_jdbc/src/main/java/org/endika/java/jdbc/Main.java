package org.endika.java.jdbc;

import org.endika.java.jdbc.model.Producto;
import org.endika.java.jdbc.repositorio.ProductoRepositorioIpl;
import org.endika.java.jdbc.repositorio.Repositorio;
import org.endika.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()){

            Repositorio<Producto> repositorio = new ProductoRepositorioIpl();
            System.out.println("------Listar----------");
            repositorio.listar().forEach(System.out::println);
            System.out.println("------Obtener porId----------");
            System.out.println(repositorio.porId(4L));
            System.out.println("------insertar nuevo producto----------");
            Producto pro = new Producto();
            pro.setNombre("mechanic keyboard");
            pro.setPrecio(500L);
            pro.setFecha(LocalDateTime.of(2025,9,1,00,00,00));
            //repositorio.guardar(pro);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);
            System.out.println("------Eliminar un producto----------");
            repositorio.eliminar(9);
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}