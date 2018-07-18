<%-- 
    Created on : Jul 16, 2018
    Author     : Mika Mähönen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/css/style.css" var="mainCss" />
        <spring:url value="/resources/images/addressbar.ico" var="barIco" />
        <spring:url value="/resources/images/logo.png" var="logo" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rest Template</title>
        <link rel="shortcut icon" href="${barIco}">
    </head>
    <body>
        <article>
          <header>
            <h1><img src="${logo}" alt="Logo"/> Rest Template</h1>
          </header>
          <p>This API has been documented with Swagger: <a href="./v2/api-docs">here</a></p>
        </article>
        
    </body>
</html>