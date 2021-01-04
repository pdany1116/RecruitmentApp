<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR">
    <h1>Pagina principala JT HR </h1>
    <c:forEach var = "user" items = "${users}" varStatus = "status">
        <div class = "row">
            <div class ="col-md-3">
                ${user.username}
            </div>
            <div class ="col-md-3">
                ${user.email}
            </div>
            <div class ="col-md-3">
                ${user.position}
            </div>
        </div>
    </c:forEach>
    
    
</t:pageTemplate>