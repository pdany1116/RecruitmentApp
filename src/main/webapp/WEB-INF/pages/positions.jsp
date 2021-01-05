<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <c:if test="${pageContext.request.isUserInRole('AdministratorRole')}">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddPosition" role="button">Add Position</a>
    </c:if>
    <c:forEach var = "position" items = "${positions}" varStatus = "status">
        <div class = "row">
            <div class ="col-md-3">
                ${position.name}
            </div>
            <div class ="col-md-3">
                ${position.maxCandidates}
            </div>
        </div>
    </c:forEach>
</t:pageTemplate>