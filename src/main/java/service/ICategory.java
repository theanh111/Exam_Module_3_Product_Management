package service;

import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {
    List<Category> findAll() throws SQLException;

    Category searchByName(String categoryName) throws SQLException;

    void addNew(Category category);

    void update(int categoryId, Category category);

    void delete (int categoryId);


}
