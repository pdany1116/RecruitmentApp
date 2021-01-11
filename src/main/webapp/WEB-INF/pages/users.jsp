<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "Users">    
    <form method="POST" action="${pageContext.request.contextPath}/Users"> 
        <div class="container">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/AddUser" role="button"> Add User</a>
            <button class="btn btn-secondary" type="submit"> Delete Users </button>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Email</th>
                            <th>Position</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "user" items = "${users}" varStatus = "status">
                            <tr>                      
                                <td> <input type="checkbox" name="user_ids" value="${user.id}" /> </td>                                
                                <td>  ${user.firstName} </td>
                                <td>  ${user.lastName} </td>
                                <td>  ${user.email} </td>
                                <td>  ${user.position} </td>
                                <td>  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button"> Edit User</a> </td>                           
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
            </div>       
        </div>    
    </form> 
</t:pageTemplate>