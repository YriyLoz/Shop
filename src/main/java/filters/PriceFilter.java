package filters;

import dao.ProductDao;
import models.Product;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
//@WebFilter(urlPatterns = "/shop", filterName = "productFilter")
//public class PriceFilter implements Filter {
//    private ProductDao productDao;
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//        productDao = new ProductDao();
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        System.out.println(servletRequest.getParameter("price_to"));
//        System.out.println(servletRequest.getParameter("price_from"));
//        if (servletRequest.getParameter("price_to") != null && servletRequest.getParameter("price_from") != null) {
//            if (getProductList(request.getSession()).size() != 0) {
//                doFilter(request);
//            }
//            if (servletRequest.getParameter("reset") != null && servletRequest.getParameter("reset").equals("price")) {
//                System.out.println("reset");
//                resetPriseFilter(request);
//            }
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//
//    private List<Product> getProductList(HttpSession session) {
//        return (List<Product>) session.getAttribute("productList");
//    }
//
//    private void resetPriseFilter(HttpServletRequest servletRequest) {
//        List<Product> products = productDao.selectAll();
//        System.out.println(products);
//        servletRequest.getSession().setAttribute("productList", products);
//    }
//
//    private void doFilter(HttpServletRequest servletRequest) {
//        HttpSession session = servletRequest.getSession();
//        int from = Integer.parseInt(servletRequest.getParameter("price_from"));
//        int to = Integer.parseInt(servletRequest.getParameter("price_to"));
//        servletRequest.getSession().setAttribute("productList",
//                getProductList(session)
//                        .stream()
//                .filter(f -> f.getPrice() <= to)
//                .filter(f -> f.getPrice() >= from)
//                .collect(Collectors.toList()));
//    }
//}
