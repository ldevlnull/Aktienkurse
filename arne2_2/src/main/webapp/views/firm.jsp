<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: devnull
  Date: 09.12.16
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aktiengesellschaft</title>
</head>
<body>
<form:form acceptCharset="utf-8" modelAttribute="firm" method="post" action="newFirm">
    <label>Name(nicht notwendig)</label>
    <form:input type="text" placeholder="Name der Aktiengesellschaft" path="name_s1" />
    <label>Kürzel</label>
    <form:input type="text" max="4" min="4" required="required" placeholder="Kürzel der Aktiengesellschaft" path="symbol" />
    <button>Eintragen</button>
</form:form>
    <a href="main">Zurück</a>
</body>
</html>
