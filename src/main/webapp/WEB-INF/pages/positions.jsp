<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <c:if test="${pageContext.request.isUserInRole('AdministratorRole')}">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddPosition?loggedId=${loggedId}" role="button">Add Position</a>    
    </c:if>
    <c:forEach var = "position" items = "${positions}" varStatus = "status">
        <c:if test="${pageContext.request.isUserInRole('AdministratorRole')}">
            <div class = "row">
                <div class ="col-md-2">
                    ${position.name}
                </div>
                <div class ="col-md-1">
                    ${position.maxCandidates}
                </div>
                <div class ="col-md-2">
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/EditPosition?positionId=${position.id}" role="button">Edit</a>
                </div>
                <div class ="col-md-2">
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/DetailsPosition?positionId=${position.id}" role="button">Details</a>
                </div>
                <div class ="col-md-2">
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ClosePosition?positionId=${position.id}" role="button">Close</a>
                </div>
                <c:if test="${position.state eq 'Inactive'}">
                    <div class ="col-md-2">
                        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ActivatePosition?positionId=${position.id}" role="button">Activate</a>
                    </div>
                </c:if> 
            </div>  
        </c:if>
        <c:if test="${position.state eq 'Active' &&  not pageContext.request.isUserInRole('AdministratorRole')}">
        <div class = "row">
                <div class ="col-md-2">
                    ${position.name}
                </div>
                <div class ="col-md-1">
                    ${position.maxCandidates}
                </div>    
        </div>    
        </c:if>   

    </c:forEach>
</t:pageTemplate>