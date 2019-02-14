<%-- 
    Document   : viewlist
    Created on : 14.02.2019, 8:30:22
    Author     : MultatulyIM
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags/inp/" %>

<c:if test="${not empty error}">
    <my:error message="${error}"/>  
</c:if>

