<%-- 
    Document   : index
    Created on : 31.01.2019, 21:53:58
    Author     : ulll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="master" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="paramset" tagdir="/WEB-INF/tags/paramset/" %>
<!DOCTYPE html>
<master:master>
    <jsp:attribute name="title">
        Home page
    </jsp:attribute>
    <jsp:body>
        <center>
            <paramset:paramset>
                <jsp:attribute name="parameter">
                    ${requestScope.parameter}
                </jsp:attribute>
            </paramset:paramset>
        </center>
    </jsp:body>
</master:master>