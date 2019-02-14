<%-- 
    Document   : viewlist
    Created on : 11.02.2019, 16:07:37
    Author     : MultatulyIM
--%>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="/Viewlist">
            <input type="submit" name="view">
        </form>
        <a href="index.jsp">Input new parameter</a>
    </body>
</html>
