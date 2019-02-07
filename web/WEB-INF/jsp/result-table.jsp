<%@page import="java.util.ArrayList"%>
<%@page import="data.Parameter;"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Parameter> list = (ArrayList<Parameter>)request.getAttribute("list"); %>
<c:set var="paramsList" value="${list}" />        
<c:import url="/WEB-INF/html/header.html" charEncoding="utf-8"/>

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
            <label>Шаблон</label>
            <input type="text" name="pattern">
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
        Внести <a href="index.html">новый параметр</a>
    </div>
</div>
<c:import url="/WEB-INF/html/footer.html" charEncoding="utf-8"/>