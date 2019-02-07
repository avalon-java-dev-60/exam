<%@page import="data.Notification"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Notification alert = (Notification) request.getAttribute("alert");%>
<c:set var="alert" value="${alert}" />        
<c:set var="session" value="${sess}" />        
<c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>
<div id="main-container">
    <div id="form-container">
        <h1>Система хранения пользовательских данных</h1>
        <h2>Вы можете заносить в базу данных набор произвольных параметров вида "имя данных" - "значение". Также Вы можете запрашивать список всех данных и данные по имени.</h2>

        <form name="input-form" method="post" action="registrator">
            <div class="place"><label for="name">Имя параметра</label>
                <input type="text" name="name" id="name"/></div>
            <div class="place"><label for="value">Значение параметра</label>
                <input type="text" name="value" id="value"/></div>
            <input type="submit" name="add" id="button" value="Внести" />
            <input type="submit" name="delete" id="button2" value="Удалить" />
            <input type="reset" name="button3" id="button3" value="Сбросить" />
        </form>
    </div>
    <div class="tutorial-info">	
        Посмотреть <a href="view-list">список</a> всех введённых параметров
    </div>
    <c:if test="${alert != null }" >
        <div class="alert <c:out value="${alert.status}"/>"><strong><c:out value="${alert.message}"/></strong></div>
    </c:if>
</div>

<c:import url="/WEB-INF/html/footer.html" charEncoding="utf-8"/>