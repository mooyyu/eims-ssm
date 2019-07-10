package filter;

import utils.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "checkLoginedFilter", urlPatterns = {"/admin", "/employee", "/department", "/overview"})
public class checkLoginedFilter implements Filter {
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (new CookieUtil().checkLogined((HttpServletRequest)req)) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("./");
        }
    }

    public void init(FilterConfig config) {}

}
