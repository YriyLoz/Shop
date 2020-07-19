package filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebFilter(urlPatterns = "/shop", filterName = "productFilter")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        if (httpServletRequest.getMethod().equals("POST")) {
//            if (httpServletRequest.getSession().getAttribute("user") == null) {
//                httpServletResponse.sendRedirect("/login");
//            } else {
//                filterChain.doFilter(servletRequest, servletResponse);
//            }
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }
//
//
//    @Override
//    public void destroy() {
//
//    }
//}
