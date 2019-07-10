package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SuperuserService;
import service.UtilsService;
import utils.CookieUtil;
import utils.Md5;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
public class LoginController extends HttpServlet {
    @Autowired
    private SuperuserService superuserService;
    @Autowired
    private UtilsService utilsService;

    public static class LoginBody {
        private String name;
        private String password;
        private String vcode;

        public LoginBody() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getVcode() {
            return vcode;
        }

        public void setVcode(String vcode) {
            this.vcode = vcode;
        }
    }

    @RequestMapping(value = "/checkLogin", method = {RequestMethod.POST})
    @ResponseBody
    public String checkLogin(@RequestBody LoginBody loginBody, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (loginBody.name != null && loginBody.password != null && loginBody.vcode != null) {
            if (loginBody.vcode.equals(request.getSession().getAttribute("vcode"))) {
                if (superuserService.checkLogin(loginBody.name, new Md5().createMD5(loginBody.password))) {
                    CookieUtil cookieUtil = new CookieUtil();
                    cookieUtil.addCookie(response, "name", loginBody.name, -1);
                    cookieUtil.addCookie(response, "password", loginBody.password, -1);
                    return "yes";
                } else {
                    return "用户名或密码错误!";
                }
            } else {
                return "验证码错误!";
            }
        } else {
            return "请将信息填写完整!";
        }
    }

    @RequestMapping(value = "/admin", method = {RequestMethod.GET})
    public String mainPage() {
        return "admin/index";
    }

    @RequestMapping("/overview")
    public String overView(HttpServletRequest request) {
        utilsService.overView(request);
        return "components/default";
    }

    @RequestMapping(value = "/exitLogin", method = {RequestMethod.GET})
    public String exitLogin(HttpServletRequest request, HttpServletResponse response) {
        new CookieUtil().clearCookie(request, response);
        return "redirect:/";
    }
}
