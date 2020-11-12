package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<Product> findAll() throws SQLException;

    Product findProductById(int productId) throws SQLException;

    List<Product> searchProductByName(String productName) throws SQLException;

    void addNew(Product product) throws SQLException;

    void update(int productId, Product product) throws SQLException;

    void delete(int productId) throws SQLException;

}
