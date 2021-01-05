<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="files/JTHRLogo18.png" alt="files/JTHRLogo18.png"/ width = 75 height = 75></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${pageContext.request.requestURI eq '' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Positions"> Positions <span class="sr-only">(current)</span></a>
            </li>
            <c:if test="${pageContext.request.isUserInRole('AdministratorRole')}">
            <li class="nav-item ${activePage eq '' ? 'active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Users">Users <span class="sr-only">(current)</span> </a>
            </li>
            </c:if>
            
            <li class="nav-item ${activePage eq '' ? 'active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}">EMPTY</a>
            </li>
        </ul>
        <ul class ="navbar-nav ml-auto">
                <li class="nav-item">
                    <c:choose>
                        <c:when test = "${pageContext.request.getRemoteUser() == null}">
                            <a class="nal-link" href="${pageContext.request.contextPath}/Login"> Login </a>
                        </c:when>
                        <c:otherwise>
                            <a class="nal-link" href="${pageContext.request.contextPath}/Logout"> Logout </a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
    </div>
</nav>
