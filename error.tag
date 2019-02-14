<%-- 
    Document   : error
    Created on : 07.02.2019, 12:24:23
    Author     : MultatulyIM
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="message"%>

<c:if test="${not empty message}">
    <p>
        ${message}
    </p>
</c:if>