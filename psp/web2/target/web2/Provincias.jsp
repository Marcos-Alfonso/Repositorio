<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Provincias españolas</title>
    <style>
        table, th, td {
            border: 1px solid;
        }
    </style>
</head>
<body>
<h1>Povincias Españolas</h1>
<p>Marcos Alfonso García</p>
<table>
    <thead>
    <tr>
        <th>Código Provincia</th>
        <th>Provincia</th>
    </tr>
    </thead>
    <tbody>
    <%
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/provincias", "root", "root");
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from provincias order by id_provincia");
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String provincia = resultSet.getString(2);
            %>
    <tr>
        <td><%= id %></td>
        <td><%= provincia %></td>
    </tr>
    <% }
        c.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    %>
    </tbody>
</table>
</body>
</html>
