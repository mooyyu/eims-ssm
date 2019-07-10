package utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 获取验证码
 * link: https://www.cnblogs.com/chiangchou/p/VCodeGenerator.html
 */
@WebServlet(name = "getVCode", urlPatterns = "/api/getVCode")
public class GetVCode extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码不能缓存
        response.setHeader("Expires", "-1");
        response.setHeader("cache-control", "no-cahce");
        response.setHeader("pragma", "no-cache");

        VCodeGenerator vcg = new VCodeGenerator();
        //取得验证码
        String vcode = vcg.generatorVCode();
        //获取验证码图片
        BufferedImage vcodeImage = vcg.generatorVCodeImage(vcode, true);
        //将验证码保存到session域对象
        request.getSession().setAttribute("vcode", vcode);
        //输出验证码图片
        ImageIO.write(vcodeImage, "gif", response.getOutputStream());
    }
}
