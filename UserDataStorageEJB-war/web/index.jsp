<%@page import="data.Notification"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Notification loginAlert = (Notification) request.getAttribute("loginAlert");%>
<c:set var="loginAlert" value="${loginAlert}" />        
<c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>
<div id="main-container">
    <div id="form-container">
        <h1>Система хранения пользовательских данных</h1>
        <h2>Авторизация</h2>
        <h4>Войти</h4>
        <form name="login-form" method="post" action="authorisation">
            <label for="name">Логин</label>
                <input type="text" name="name" id="name"/>
                <input type="submit" name="login" id="button" value="Войти" />
        </form>
        <h4>или зарегистрироваться</h4>
        <form name="sign-up-form" method="post" action="userRegistration">
            <label for="name">Логин</label>
                <input type="text" name="name" id="name"/>
                <input type="submit" name="sign-up" id="button" value="Регистрация" />
        </form>       
    </div>
    <c:if test="${loginAlert != null }" >
        <div class="alert <c:out value="${loginAlert.status}"/>"><strong><c:out value="${loginAlert.message}"/></strong></div>
    </c:if>
</div>
<c:import url="/WEB-INF/html/footer.html" charEncoding="utf-8"/>