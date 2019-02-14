<%-- 
    Document   : newpage
    Created on : 11.02.2019, 10:29:54
    Author     : MultatulyIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="inp" tagdir="/WEB-INF/tags/inp/" %>
<!DOCTYPE html>
<my:master>
    <jsp:attribute name="title">
        New parameter
    </jsp:attribute>

    <jsp:body>
      
        <center>
            <inp:newpar>
                <jsp:attribute name="parameter">
                    ${requestScope.parameter}
                </jsp:attribute>
                <jsp:attribute name="p_value">
                    ${requestScope.p_value}
                </jsp:attribute>
            </inp:newpar>
        </center>
        
    </jsp:body>    


</my:master>
