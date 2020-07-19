package filters;

import dao.ProductDao;
import models.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseFilter {
    private List<Product> products = new LinkedList<>();

    List<Product> sortListProducer(List<Product> productList, HttpServletRequest req, String filter) {
        products = productList.stream()
                .filter(e -> e.getProducer()
                        .equals(req.getParameter(filter)))
                .collect(Collectors.toList());
        return products;
    }

    List<Product> sortListColor(List<Product> productList, HttpServletRequest req, String filter) {
        products = productList.stream()
                .filter(e -> e.getColor()
                        .equals(req.getParameter(filter)))
                .collect(Collectors.toList());
        return products;
    }

    List<Product> getProductList(HttpServletRequest request) {
        return (List<Product>) request.getSession().getAttribute("productList");

    }

    void resetFilter(HttpServletRequest servletRequest, ProductDao productDao) {
        servletRequest.getSession().setAttribute("productList", productDao.selectAll());
    }


}
