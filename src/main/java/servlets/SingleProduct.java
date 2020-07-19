package servlets;


import dao.ProductDao;
import models.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
@WebServlet(urlPatterns = "/product", name = "SingleProduct")
public class SingleProduct extends HttpServlet {
    private ProductDao productDao;
    private static int cookieCount;

    public void init() {
        productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("product_id") != null) {
            System.out.println(productDao.selectById(Integer.parseInt(req.getParameter("product_id"))));
            req.setAttribute("product", productDao.selectById(Integer.parseInt(req.getParameter("product_id"))));
        }
        req.getRequestDispatcher("single-product.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("addToCart") != null) {
            addToCartProduct(req, resp);
            System.out.println(req.getSession().getAttribute("cart"));
        }
        resp.sendRedirect("/product?product_id=" + req.getParameter("product_id"));
    }

    private void addToCartProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList;
        if (request.getSession().getAttribute("cart") != null) {
            productList = (List<Product>) request.getSession().getAttribute("cart");
        } else {
            productList = new LinkedList<>();
        }
        Product product = productDao.selectById(Integer.parseInt(request.getParameter("addToCart")));
        productList.add(product);
        request.getSession().setAttribute("cart", productList);
        String name = "Cookie" + (++cookieCount);
        Cookie cookie = new Cookie(name, product.getId().toString());
        response.addCookie(cookie);
    }
}
