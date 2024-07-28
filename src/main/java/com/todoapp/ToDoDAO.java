package com.todoapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {
    public void addToDo(ToDo todo) {
        String sql = "INSERT INTO todos (title) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTitle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ToDo> getAllToDos() {
        List<ToDo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ToDo todo = new ToDo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setStatus(rs.getBoolean("status"));
                todo.setCreatedAt(rs.getTimestamp("created_at"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todos;
    }

    public void updateToDoStatus(int id, boolean status) {
        String sql = "UPDATE todos SET status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
