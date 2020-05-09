
<%@page import="database.DBParameter"%>
<%@page import="java.util.List"%>
<% List<DBParameter> list = (List<DBParameter>) request.getAttribute("list"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="parameterList" value="${list}" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ViewList page</title>
    </head>
    <body>
        <h1>You can view Parameter and Values here</h1>
        <form method="post" action="/labExam/viewlist">
            <label>You can print all:
                <button type="submit" name="allButton">Print</button>
            </label>
        </form> 
        <form method="post" action="/labExam/viewlist">
            <label>You can enter text template:
                <input type="text" name="userTemplate" value="${userParameter}" maxlength="255">
                <button type="submit" name="templateButton">Print</button>
            </label>
        </label>
    </form>
    <form method="post" action="/labExam/viewlist">
        <label>You can enter interval:
            <input type="number" name="userBeginValue" value="${userValue}" pattern="\d">
            <input type="number" name="userEndValue" value="${userValue}" pattern="\d">
            <button type="submit" name="intervalButton">Print</button>
    </form> 
    <form method="post" action="/labExam/registrator">
        <button type="submit" name="registratorButton">Return to Registator</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Parameter</th>
                <th>Value</th>
            </tr>
        </thead>
    </table>   
    <table>
        <c:forEach var="parameter" items="${parameterList}" >
            <tr>
                <td><c:out value="${parameter.getParam()}"/></td>
                <td><c:out value="${parameter.getValue()}"/></td>
            </tr>
        </c:forEach>
    </table>

    <%
        if (request.getAttribute("error") != null) {
            out.println("<p>" + request.getAttribute("error") + "</p>");
        }
    %>
    <style>
        input[type='number'] {
            -moz-appearance:textfield;
        }

        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
    </style>
</body>
</html>
