<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <c:if test = "${  pageContext.request.isUserInRole('RecruiterRole') || 
                      pageContext.request.isUserInRole('DirectorGeneralRole') ||
                      pageContext.request.isUserInRole('DirectorHRRole') || 
                      pageContext.request.isUserInRole('DirectorDepartamentRole')}">
          <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddPosition?loggedId=${loggedId}" role="button">Add Position</a>    
    </c:if>
    <c:forEach var = "position" items = "${positions}" varStatus = "status">
        <c:choose>
            <c:when test = "${  pageContext.request.isUserInRole('RecruiterRole') || 
                                pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                pageContext.request.isUserInRole('DirectorHRRole') || 
                                pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                    <div class = "row">
                        <div class ="col-md-2">
                            ${position.name}
                        </div>
                        <div class ="col-md-1">
                            ${position.maxCandidates}
                        </div>
                        <div class ="col-md-1">
                            ${position.user.firstName} ${position.user.lastName}  
                        </div>
                        <div class ="col-md-2">
                            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/DetailsPosition?positionId=${position.id}" role="button">Details</a>
                        </div>
                        <c:if test = "${  pageContext.request.isUserInRole('RecruiterRole') || 
                                          pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                          pageContext.request.isUserInRole('DirectorHRRole') || 
                                          pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                              <div class ="col-md-2">
                                  <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/EditPosition?positionId=${position.id}" role="button">Edit</a>
                              </div>
                        </c:if>


                        <c:if test = "${position.state eq 'Active' && pageContext.request.isUserInRole('RecruiterRole')}">
                            <div class ="col-md-2">
                                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddCandidate?positionId=${position.id}" role="button">Add Candidate</a>
                            </div>
                        </c:if>
                        
                        <c:if test="${position.state eq 'Inactive' && pageContext.request.isUserInRole('DirectorGeneralRole')}">
                            <div class ="col-md-2">
                                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ActivatePosition?positionId=${position.id}" role="button">Activate</a>
                            </div>
                        </c:if> 
                        <c:if test="${position.state eq 'Closed' && pageContext.request.isUserInRole('DirectorGeneralRole')}">
                            <div class ="col-md-2">
                                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ReactivatePosition?positionId=${position.id}" role="button">Reactivate</a>
                            </div>
                        </c:if>
                        <c:if test = "${(position.state eq 'Inactive' || position.state eq 'Active') && (pageContext.request.isUserInRole('DirectorGeneralRole'))}">
                            <div class ="col-md-2">
                                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ClosePosition?positionId=${position.id}" role="button">Close</a>
                            </div>
                        </c:if>
                    </div>        
            </c:when>
            <c:when test = "${not pageContext.request.isUserInRole('')}">
                <c:if test = "${(position.state eq 'Active')}">
                    <div class = "row">
                        <div class ="col-md-2">
                            ${position.name}
                        </div>
                        <div class ="col-md-1">
                            ${position.maxCandidates}
                        </div> 
                        <div class ="col-md-1">
                            ${position.user.firstName} ${position.user.lastName}
                        </div>
                        <div class ="col-md-2">
                            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/DetailsPosition?positionId=${position.id}" role="button">Details</a>
                        </div>
                    </div>                     
                </c:if>
            </c:when>
        </c:choose>
    </c:forEach>
</t:pageTemplate>