package com.thunisoft.shop.servlet;

import com.thunisoft.shop.utils.VerifyCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author ljw
 * @Date 2018/7/10 14:49
 * @Version 1.0
 **/
public class AuthImageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");

        //生成随机字串+生成验证图
        String verifyCode = VerifyCodeUtil.outputVerifyImage(100,30,resp.getOutputStream(),4);
        //放入request
        req.getSession().setAttribute("verifyCode",verifyCode.toLowerCase());
    }
}
