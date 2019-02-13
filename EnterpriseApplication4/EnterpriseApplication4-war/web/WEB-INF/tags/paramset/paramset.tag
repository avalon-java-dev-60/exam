<%-- 
    Document   : paramset
    Created on : 31.01.2019, 22:01:57
    Author     : ulll
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="msg" tagdir="/WEB-INF/tags/core/" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="parameter"%>
<%@attribute name="message" %>


<c:if test="${not empty message}">
    <msg:message message="${message}"/>
</c:if>

<h1>Внесение изменений в базу данных</h1>
<form method="POST" action="/EnterpriseApplication4-war/registrator" >
    <label>Parameter name</label><br/>
    <input name="Parameter" type="text" value="${parameter}" title="Enter parameters name. max length 255"><br/> 
    <label>Value</label><br/>
    <input name="Value" type="text" title="Enter value for parameter. Digits only"> <br/>
    <p><button name="Set" type="submit" title="Save parameters name and value in database">Set</button>
        <button name="Delete" type="submit" title="Delete parameter from database">Delete</button>
        <button type="reset" title="Clear text fields">Clear</button></p>
    
    <input name="View" type="submit" value="View" title="Go to view page"> 
</form>
