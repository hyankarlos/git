<%-- 
    Document   : conexao
    Created on : 30/10/2012, 21:50:29
    Author     : hyan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page language="java" import="java.sql.*, java.io.*"%>
        <%
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VirtualManager", "root", "root");
            Statement statement = con.createStatement();
        %>
    </body>
</html>
