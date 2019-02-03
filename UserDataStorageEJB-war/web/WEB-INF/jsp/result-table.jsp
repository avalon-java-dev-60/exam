<%@page import="data.Notification"%>
<%@page import="database.Params"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Params> list = (List<Params>)request.getAttribute("list"); %>
<% Notification alert = (Notification) request.getAttribute("alert");%>
<c:set var="paramsList" value="${list}" /> 
<c:set var="alert" value="${alert}" />
<c:import url="/WEB-INF/jsp/header.jsp" charEncoding="utf-8"/>

<div id="main-container" class = "grid-container">
    <div id="form-container">
        <h1>Система хранения пользовательских данных</h1>
        <h2>Список параметров</h2>
        <form method="GET" action="view-list" class="choose">
            <span>Весь список</span>
            <input type="submit" name="all" value="Показать">
       </form>
       <form method="GET" action="view-list" class="choose">
            <p>По шаблону имени параметра</p>
            <label>Шаблон %</label>
            <input type="text" name="pattern">
            <label>%</label>
            <input type="submit" name="pattern-button" value="Показать">
       </form>
       <form method="GET" action="view-list" class="choose">
            <p>По диапазону значений</p>
            <label>От</label>
            <input type="text" name="from" size="10">
            <label>До</label>
            <input type="text" name="to" size="10">
            <input type="submit" name="range-button" value="Показать">
       </form>
        <c:choose>           
            <c:when test="${alert != null}">
                <div class="alert <c:out value="${alert.status}"/>">
                    <strong><c:out value="${alert.message}"/></strong>
                </div>
            </c:when>
            <c:when test="${paramsList != null and paramsList.size() != 0 }">
                <table>
                  <c:forEach var="parametr" items="${paramsList}" >
                      <tr>
                        <td><c:out value="${parametr.getName()}"/></td>
                        <td><c:out value="${parametr.getValue()}"/></td>
                      </tr>
                  </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <div class='alert alert-info'><strong>По Вашему запросу ничего не найдено</div>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="tutorial-info">	
        Внести <a href="registrator.jsp">новый параметр</a>
    </div>
</div>
<c:import url="/WEB-INF/html/footer.html" charEncoding="utf-8"/>