package com.app.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Danil-MAC on 10/21/16.
 */
@WebServlet(name = "SecondServlet", urlPatterns = "/second")
public class SecondServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        super.service(req, resp);
        long finish = System.currentTimeMillis()-start;
        System.out.println("Service.Second.Time="+finish);


        Enumeration<String> en=req.getHeaderNames();
        while(en.hasMoreElements()){
            String key= en.nextElement();
            System.out.println(String.format("%s=%s", key, req.getHeader(key)));

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        System.out.println("Post");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   super.doGet(req, resp);
        System.out.println("Get");
    }
}
