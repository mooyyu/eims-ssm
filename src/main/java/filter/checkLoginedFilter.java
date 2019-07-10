package filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.SuperuserService;
import utils.CookieUtil;
import utils.Md5;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class checkLoginedFilter implements Filter {
    private CookieUtil cookieUtil = new CookieUtil();
    @Autowired
    private SuperuserService superuserService;

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String name = cookieUtil.getValueByKey((HttpServletRequest)req, "name");
        String password = cookieUtil.getValueByKey((HttpServletRequest)req, "password");
        if (superuserService.checkLogin(name, new Md5().createMD5(password))) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("./");
        }
    }

    public void init(FilterConfig config) {}

}
