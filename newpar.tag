<%-- 
    Document   : newpar
    Created on : 11.02.2019, 10:45:15
    Author     : MultatulyIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags/inp/" %>

<%@attribute name="parameter" %>
<%@attribute name="error" %>
<%@attribute name="p_value"%>

<c:if test="${not empty error}">
    <my:error message="${error}"/>  
</c:if>

<form method="post" action="Registrator">
    <label>Parameter name</label> <br>
    <input type="text" name="parameter"/>
    <br/>
    <label>Parameter value</label> <br>
    <input type="text" name="p_value"/>
    <br>
    <button>Input</button>
    <br>
    <a href="viewlist.jsp">View parameters</a>
</form>
<form method="get" action="Registrator">
    <button>ViewList</button>       
</form>
