package uz.muhammad.filters;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;

import javax.servlet.*;
import java.io.IOException;

public class BookAddFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
