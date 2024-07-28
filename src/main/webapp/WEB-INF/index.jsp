<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ToDo List</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .completed { text-decoration: line-through; }
    </style>
</head>
<body>
    <h1>ToDo List</h1>
    <form action="todos" method="post">
        <input type="text" name="title" placeholder="Type your todo here..." required>
        <input type="hidden" name="action" value="add">
        <button type="submit">Add ToDo</button>
    </form>
    <ul>
        <c:forEach var="todo" items="${todos}">
            <li class="${todo.status ? 'completed' : ''}">
                ${todo.title}
                <form action="todos" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="${todo.id}">
                    <input type="hidden" name="status" value="${!todo.status}">
                    <input type="hidden" name="action" value="update">
                    <button type="submit">${todo.status ? 'Mark as Incomplete' : 'Mark as Complete'}</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
