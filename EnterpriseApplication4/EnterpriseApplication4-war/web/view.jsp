<%-- 
    Document   : view
    Created on : 05.02.2019, 21:58:09
    Author     : ulll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="msg" tagdir="/WEB-INF/tags/core/" %>
<%-- The list of normal or fragment attributes can be specified here: --%>



<center>
<c:if test="${not empty message}">
    <h1><msg:message message="${message}"/></h1> 
</c:if>

<h1>Промотр базы данных</h1>
<h3>
    Для просмотра информации введите:<br/>
    -имя параметра или часть имени <br/>
    -значение параметра или интервал значений<br/>
</h3>

<form method="POST" action="/ParameterBase/viewlist" >
    <label>Parameter name</label><br/>
    <input name="Parameter" type="text" value="${parameter}" title="Enter parameters name. max length 255"><br/> 
    <label>Value</label><br/>
   
    <input name="from" type="number" step="1">
    <input name="to" type="number" step="1">
    <p><button name="Set" type="submit" title="Save parameters name and value in database">Find</button>
        
        <button type="reset" title="Clear text fields">Clear</button></p>
    

</form>

</center>