<%-- 
    Document   : ViewList
    Created on : 03.02.2019, 10:18:34
    Author     : Havok
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ViewList page</title>
    </head>
    <body>
        <h1>You can view Parameter and Values</h1>
        <form method="post" action="/labExam/viewlist">
            <label>Parameter:
                <input type="text" name="userParameter" value="${userParameter}" maxlength="255">
                <button type="submit" name="submitButton">Submit</button>
                <label>Value:
                    <input type="number" name="userValue" value="${userValue}" pattern="\d">
                    <button type="submit" name="submitButton">Submit</button>
                </label>
                <br />
            </label>

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
        <c:forEach var="Example" items="${list}">
        <tr>
        <td></td>
        <td><c:out value="${list.parameter}"/></td>
        <td><c:out value="${list.parameter}"/></td>
        </c:forEach>
        <%if (request.getAttribute("message1") != null) {

                out.println("<p>This Parameter: " + request.getAttribute("message1") + "</p>");
            }
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
