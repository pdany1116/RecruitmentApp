<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <c:if test="${pageContext.request.isUserInRole('AdministratorRole')}">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddPosition" role="button">Add Position</a>
    </c:if>
    <c:forEach var = "position" items = "${positions}" varStatus = "status">
        <div class = "row">
            <div class ="col-md-2">
                ${position.name}
            </div>
            <div class ="col-md-1">
                ${position.maxCandidates}
            </div>
            <div class ="col-md-2">
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/EditPosition" role="button">Edit</a>
            </div>
            <div class ="col-md-2">
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/DetailsPosition" role="button">Details</a>
            </div>
            <div class ="col-md-2">
                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ClosePosition" role="button">Close Position</a>
            </div>
            
        </div>
    </c:forEach>
</t:pageTemplate>