<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-center">
    <div style="padding-left: 30px; padding-top: 30px; padding-right: 100px;">
        <a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="files/JTHRLogo18.png" alt="files/JTHRLogo18.png" width = 100 height = 100 ></a>
    </div>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse navbar-header" id="navbarsExampleDefault" style="text-align: center">
        
            <ul class="navbar-nav mr-auto">
                <li class="nav-item ${pageContext.request.requestURI eq '' ? ' active' : ''}">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/Positions"> Positions <span class="sr-only">(current)</span></a>
                </li>

                <c:if test="${pageContext.request.isUserInRole('AdministratorRole') ||
                              pageContext.request.isUserInRole('DirectorGeneralRole')}">
                    <li class="nav-item ${activePage eq '' ? 'active' : ''}">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/Users"> Users <span class="sr-only">(current)</span> </a>
                    </li>
                </c:if>
            </ul>
        
            <div style="padding-right: 50px;">    
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
    </div>
</nav>
