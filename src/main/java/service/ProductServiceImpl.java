package service;

import model.Category;
import model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProduct {
    Connection connection = ConnectDB.getConnect();

    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    private static final String SELECT_ALL_PRODUCT = "{CALL selectAllProduct()}";
    private static final String SELECT_PRODUCT_BY_ID = "{CALL selectProductById(?)}";
    private static final String DELETE_PRODUCT_BY_ID = "{CALL deleteProductById(?)}";
    private static final String UPDATE_PRODUCT_BY_ID = "{CALL updateProductById(?,?,?,?,?,?,?)}";
    private static final String INSERT_NEW_PRODUCT = "{CALL addNewProduct(?,?,?,?,?,?,?)}";
    private static final String SEARCH_PRODUCT_BY_NAME = "{CALL searchProductByName(?)}";

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_PRODUCT);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productName = rs.getString("productName");
            double productPrice = rs.getDouble("productPrice");
            int productQuantity = rs.getInt("productQuantity");
            String productColor = rs.getString("productColor");
            String productDesc = rs.getString("productDesc");
            Category category = categoryService.searchByName(rs.getString("categoryName"));
            Product product = new Product(productId, productName, productPrice, productQuantity, productColor, productDesc, category);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product findProductById(int productId) throws SQLException {
        Product product = null;
        CallableStatement callableStatement = connection.prepareCall(SELECT_PRODUCT_BY_ID);
        callableStatement.setInt(1, productId);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            String productName = rs.getString("productName");
            double productPrice = rs.getDouble("productPrice");
            int productQuantity = rs.getInt("productQuantity");
            String productColor = rs.getString("productColor");
            String productDesc = rs.getString("productDesc");
            Category category = categoryService.searchByName(rs.getString("categoryName"));
            product = new Product(productId, productName, productPrice, productQuantity, productColor, productDesc, category);
        }
        return product;
    }

    @Override
    public void addNew(Product product) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(INSERT_NEW_PRODUCT);
        callableStatement.setInt(1, product.getProductId());
        callableStatement.setString(2, product.getProductName());
        callableStatement.setDouble(3, product.getProductPrice());
        callableStatement.setInt(4, product.getProductQuantity());
        callableStatement.setString(5, product.getProductColor());
        callableStatement.setString(6, product.getProductDesc());
        callableStatement.setString(7, product.getCategory().getCategoryName());
        callableStatement.executeUpdate();
    }

    @Override
    public void update(int productId, Product product) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(UPDATE_PRODUCT_BY_ID);
        callableStatement.setInt(1, product.getProductId());
        callableStatement.setString(2, product.getProductName());
        callableStatement.setDouble(3, product.getProductPrice());
        callableStatement.setInt(4, product.getProductQuantity());
        callableStatement.setString(5, product.getProductColor());
        callableStatement.setString(6, product.getProductDesc());
        callableStatement.setString(7, product.getCategory().getCategoryName());
        callableStatement.executeUpdate();
    }

    @Override
    public void delete(int productId) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(DELETE_PRODUCT_BY_ID);
        callableStatement.setInt(1, productId);
        callableStatement.executeUpdate();
    }

    @Override
    public List<Product> searchProductByName(String productName) throws SQLException {
        List<Product> productListByName = new ArrayList<>();
        CallableStatement callableStatement = connection.prepareCall(SEARCH_PRODUCT_BY_NAME);
        callableStatement.setString(1, productName);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productByName = rs.getString("productName");
            double productPrice = rs.getDouble("productPrice");
            int productQuantity = rs.getInt("productQuantity");
            String productColor = rs.getString("productColor");
            String productDesc = rs.getString("productDesc");
            Category category = categoryService.searchByName(rs.getString("categoryName"));
            Product products = new Product(productId, productByName, productPrice, productQuantity, productColor, productDesc, category);
            productListByName.add(products);
        }
        return productListByName;
    }
}
