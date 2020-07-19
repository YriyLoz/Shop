package filters;

import dao.ProductDao;
import models.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/shop", filterName = "Filter")
public class ProductFilter extends BaseFilter implements Filter {
    private ProductDao productDao;
    private final static String PRODUCER = "producer";
    private final static String COLOR = "color";
    private final static String FILTER = "filter";

    public void init(FilterConfig config) {
        productDao = new ProductDao();
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        resetFilter(request, productDao);
        if (req.getParameter(PRODUCER) != null) {
            request.getSession().setAttribute("productList", sortListProducer(getProductList(request), request, PRODUCER));
        } else if (req.getParameter(COLOR) != null) {
            request.getSession().setAttribute("productList", sortListColor(getProductList(request), request, COLOR));
        }
        if (req.getParameter("reset") != null && req.getParameter("reset").equals(FILTER)) {
            resetFilter(request, productDao);
        }
        chain.doFilter(req, resp);
    }

}

