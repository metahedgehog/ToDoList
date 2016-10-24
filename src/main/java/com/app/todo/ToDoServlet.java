package com.app.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@WebServlet(name = "ToDoServlet", urlPatterns = "/todo")
public class ToDoServlet extends HttpServlet {

    private List<ToDoTask> taskList = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkAndRemoveCompleted(req);
        resp.sendRedirect("index.jsp");
    }

    private void checkAndRemoveCompleted(HttpServletRequest request) {
        if (request.getParameterValues("completed") != null) {
            String[] completedTasks = request.getParameterValues("completed");
            for (int completedIterator = 0; completedIterator < completedTasks.length; completedIterator++) {
                for (ToDoTask task : taskList) {
                    if (Objects.equals(completedTasks[completedIterator], task.getTaskName())) {
                        taskList.remove(task);
                        break;
                    }
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        String taskCategory = request.getParameter("taskCategory");
        ToDoTask task = new ToDoTask(taskName, taskCategory);
        HttpSession session = request.getSession();
        if (TaskValidator.isValid(task)) {
            taskList.add(task);
            session.setAttribute("taskList", taskList);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

}
