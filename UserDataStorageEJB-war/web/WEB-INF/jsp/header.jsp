<%  String login = (String)session.getAttribute("login");%>
<c:set var="login" value="${login}" /> 
<!DOCTYPE html>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Storage System</title>
<link rel="stylesheet" type="text/css" href="djqtransformplugin/jqtransform.css" />
<link rel="stylesheet" type="text/css" href="demo.css" />
</head>
<body>
    <c:if test="${login != null }" >
        <div id="user-login">
            ${login}
        </div>
    </c:if>
    
