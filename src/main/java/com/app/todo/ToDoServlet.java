package com.app.todo;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ToDoServlet", urlPatterns = "/todo")
public class ToDoServlet extends HttpServlet {

    private List<ToDoTask> taskList= new ArrayList<>();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
        String taskName = request.getParameter("taskName");
        String taskCategory = request.getParameter("taskCategory");
        ToDoTask task = new ToDoTask(taskName, taskCategory);
        HttpSession session = request.getSession();
        if(TaskValidator.isValid(task)){
            taskList.add(task);
            session.setAttribute("taskList", taskList);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }

    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

}
