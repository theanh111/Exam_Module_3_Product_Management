package service;

import model.Category;
import model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategory {
    Connection connection = ConnectDB.getConnect();

    private static final String SELECT_ALL_CATEGORY = "{CALL selectAllCategory()}";
    private static final String SEARCH_CATEGORY_BY_NAME = "{CALL searchCategoryByName(?)}";

    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_CATEGORY);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            int categoryId = rs.getInt("categoryId");
            String categoryName = rs.getString("categoryName");
            Category category = new Category(categoryId, categoryName);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Category searchByName(String categoryName) throws SQLException {
        Category category = null;
        CallableStatement callableStatement = connection.prepareCall(SEARCH_CATEGORY_BY_NAME);
        callableStatement.setString(1, categoryName);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            int categoryId = rs.getInt("categoryId");
            category = new Category(categoryId, categoryName);
        }
        return category;
    }

    @Override
    public void addNew(Category category) {

    }

    @Override
    public void update(int categoryId, Category category) {

    }

    @Override
    public void delete(int categoryId) {

    }
}
