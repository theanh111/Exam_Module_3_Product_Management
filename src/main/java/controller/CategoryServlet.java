package controller;

import model.Category;
import model.Product;
import service.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {

    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "addProduct":
//                addProduct(request, response);
//                break;
//            case "editProduct":
//                editProduct(request, response);
//                break;
//            case "deleteProduct":
//                deleteProduct(request, response);
//                break;
//            case "searchProductByName":
//                searchProductByName(request, response);
//                break;
            default:
                try {
                    listCategories(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void listCategories(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("categories", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
        dispatcher.forward(request, response);
    }
}
