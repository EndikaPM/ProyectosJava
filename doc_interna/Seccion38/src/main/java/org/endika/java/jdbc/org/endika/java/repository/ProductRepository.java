package org.endika.java.jdbc.org.endika.java.repository;

import org.endika.java.jdbc.org.endika.java.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void delete(long id);
}
