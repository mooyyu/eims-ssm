package utils;

import org.springframework.beans.factory.annotation.Autowired;
import service.SuperuserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对于Cookie的操作池
 */
@WebServlet(name = "CookieUtil")
public class CookieUtil extends HttpServlet {
    @Autowired
    private SuperuserService superuserService;

    /**
     * 通过key返回cookie的value
     * @param request
     * @param key
     * @return
     */
    public String getValueByKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 通过cookie中保存的邮件地址和加密密码和userId验证用户是否已经登录。
     * @param request
     * @return
     */
    public boolean checkLogined(HttpServletRequest request) {
        String name = getValueByKey(request, "name");
        String password = getValueByKey(request, "password");

        if (name != null && password != null) {
            if (superuserService.checkLogin(name, new Md5().createMD5(password))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 在当前request中添加cookie
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxAge
     */
    public void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(cookieMaxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 清空当前request的所有cookie
     * @param request
     * @param response
     */
    public void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
    }
}