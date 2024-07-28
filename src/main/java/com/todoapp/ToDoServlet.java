package com.todoapp;

import java.io.IOException;

import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todos")
public class ToDoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ToDoDAO todoDAO = new ToDoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ToDo> todos = todoDAO.getAllToDos();
        request.setAttribute("todos", todos);
        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            ToDo todo = new ToDo(title);
            todoDAO.addToDo(todo);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            todoDAO.updateToDoStatus(id, status);
        }

        response.sendRedirect("todos");
    }
}
