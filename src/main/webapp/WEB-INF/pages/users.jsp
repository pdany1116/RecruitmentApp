<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Users">
   
    <c:if test="${pageContext.request.isUserInRole('AdministratorRole')}">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser" role="button"> Add User</a>
    </c:if>
    <c:forEach var = "user" items = "${users}" varStatus = "status">
        <div class = "row">
            <div class ="col-md-3">
                ${user.firstname}
            </div>
            <div class ="col-md-3">
                ${user.lastname}
            </div>
            <div class ="col-md-3">
                ${user.email}
            </div>
            <div class ="col-md-3">
                ${user.position}
            </div>
            
             <div class="col-md-3">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button"> Edit User</a>
             </div>
             
        </div>
    </c:forEach>
    
    
</t:pageTemplate>