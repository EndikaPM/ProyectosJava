package org.endika.java.jdbc.repositorio;

import org.endika.java.jdbc.model.Producto;
import org.endika.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioIpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
       return  ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto>productos = new ArrayList<>();
        try(PreparedStatement sente = getConnection().prepareStatement("SELECT * FROM producto");
            ResultSet res = sente.executeQuery()){
            while (res.next()){
                Producto p = crearProducto(res);
                productos.add(p);

            }
        }catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(long id) {
        Producto producto = null;
        try(PreparedStatement stmt = getConnection()
                .prepareStatement("Select * FROM producto WHERE id =?")){
            stmt.setLong(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    producto = crearProducto(rs);
                }
            }
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE producto SET nombre=?, precio=? WHERE id=?";
        } else {
            sql = "INSERT INTO producto(nombre, precio, fecha) VALUES(?,?,?)";
        }
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecio());
            if (producto.getId() != null && producto.getId() > 0) {
                ps.setLong(3,producto.getId());
            }else {
                ps.setDate(3,Date.valueOf(producto.getFecha().toLocalDate()));
                // MIRAR ESTO (Date.valueOf) creo que set es Date.valueOf y get es .toLocalDate
            }
            ps.executeUpdate();
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(long id) {
        try(PreparedStatement ps = getConnection().prepareStatement("DELETE FROM producto WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();//IMPORTANTE SE TE OLVIDA SIEMPRE!!!!!!
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }

    }
    private static Producto crearProducto(ResultSet res) throws SQLException {
        Producto p = new Producto();
        p.setId(res.getLong(1));
        p.setNombre(res.getString(2));
        p.setPrecio(res.getFloat(3));
        Timestamp timestamp = res.getTimestamp("fecha");
        p.setFecha(timestamp.toLocalDateTime());
        return p;
    }
}
