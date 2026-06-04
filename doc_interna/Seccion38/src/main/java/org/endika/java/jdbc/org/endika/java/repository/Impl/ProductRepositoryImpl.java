package org.endika.java.jdbc.org.endika.java.repository.Impl;

import org.endika.java.jdbc.org.endika.java.db.ConnectionJdbc;
import org.endika.java.jdbc.org.endika.java.model.Product;
import org.endika.java.jdbc.org.endika.java.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from products");
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                Product product = new Product(rs.getLong("id"),
                                            rs.getString("name"),
                                            rs.getFloat("price"),
                                            rs.getFloat("quantity") );

                products.add(product);

            }

        }catch (SQLException e) {
         e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;

        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from products where id=?")){

            stmt.setLong(1,id);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){//ya que solo existe un id valido
                    product = new Product(rs.getLong("id"),
                            rs.getString("name"),
                            rs.getFloat("price"),
                            rs.getFloat("quantity") );



                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product save(Product product) {

        boolean isUpdate = (product.getId() != null && product.getId() > 0);

        String sql = isUpdate
                ? "UPDATE products SET name=?, price=?, quantity=? WHERE id=?"
                : "INSERT INTO products (name, price, quantity) VALUES(?, ?, ?)";

        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement preStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preStmt.setString(1, product.getName());
            preStmt.setFloat(2, product.getPrice());
            preStmt.setFloat(3, product.getQuantity());

            if (isUpdate) {
                preStmt.setLong(4, product.getId());
            }

            int affectedRows = preStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No se pudo guardar el producto, ninguna fila afectada.");
            }


            if (!isUpdate) {

                try (ResultSet rs = preStmt.getGeneratedKeys()) {
                    if (rs.next()) {

                        long generatedId = rs.getLong(1);
                        product.setId(generatedId);
                    }
                }
            }

            return product;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(long id) {
        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE from products where id=?")){

            stmt.setLong(1,id);
            stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
