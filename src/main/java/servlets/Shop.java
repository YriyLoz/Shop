package servlets;

import dao.FilterDao;
import dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/shop", name = "Shop")
public class Shop extends HttpServlet {
    private ProductDao productDao;

    public void init() {
        productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        viewProducts(req);
        viewFilters(req);
        req.getRequestDispatcher("/shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    private void viewFilters(HttpServletRequest request) {
        try {
            request.getServletContext().setAttribute("typeFilter", FilterDao.getAllType());
            request.getServletContext().setAttribute("colorFilter", FilterDao.getAllColors());
            request.getServletContext().setAttribute("producerFilter", FilterDao.getAllProducers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewProducts(HttpServletRequest request) {
        if (request.getSession().getAttribute("productList") == null)
            request.getSession().setAttribute("productList", productDao.selectAll());
    }

}
