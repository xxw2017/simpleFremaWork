package com.xxw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleframework.core.annotation.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiongxianwei
 * 2020/6/1 0001
 */

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private Logger logger= LoggerFactory.getLogger(HelloServlet.class);
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name="我是简易框架！";
        logger.debug(name);
        request.setAttribute("name",name);
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request,response);
    }
}
