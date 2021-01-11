<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR">
    <c:if test="${message != null}">
        <div class="alert alert-warning" role="alert">
            ${message}
        </div>
    </c:if>

    <div class="d-flex justify-content-center align-items-center">
        <form class="form-signin" method="POST" action="j_security_check">
            <div style="width: 400px; padding-top: 70px;">
                <h1 class="text-center" style="padding-bottom: 30px;">Sign in</h1>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="j_username" class="form-control" placeholder="Username" required autofocus>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="j_password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </div>
        </form>
    </div>
</t:pageTemplate>