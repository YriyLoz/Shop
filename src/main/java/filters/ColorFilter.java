package filters;


import dao.ProductDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = "/shop", filterName = "colorFilter")
//public class ColorFilter extends BaseFilter implements Filter {
//    private ProductDao productDao;
//    private final static String COLOR = "color";
//
//    public void init(FilterConfig config) {
//        productDao = new ProductDao();
//    }
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        if (req.getParameter(COLOR) != null) {
//            resetFilter(request, productDao);
//            request.getSession().setAttribute("productList", sortList(getProductList(request), request, COLOR));
//        }
//        if (req.getParameter("reset") != null && req.getParameter("reset").equals(COLOR)) {
//            resetFilter(request, productDao);
//        }
//        chain.doFilter(req, resp);
//    }
//}
