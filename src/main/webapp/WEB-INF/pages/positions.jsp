<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <div class="container">
        <c:if test = "${  pageContext.request.isUserInRole('RecruiterRole') || 
                          pageContext.request.isUserInRole('DirectorGeneralRole') ||
                          pageContext.request.isUserInRole('DirectorHRRole') || 
                          pageContext.request.isUserInRole('DirectorDepartamentRole')}">
              <a class="btn btn-primary" href="${pageContext.request.contextPath}/AddPosition?loggedId=${loggedId}" role="button">Add Position</a>    
        </c:if>
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Candidates</th>
                        <th>Author</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "position" items = "${positions}" varStatus = "status">
                        <tr>
                            <c:choose>
                                <c:when test = "${  pageContext.request.isUserInRole('RecruiterRole') || 
                                                    pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                                    pageContext.request.isUserInRole('DirectorHRRole') || 
                                                    pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                                        <td>
                                            ${position.name}
                                        </td>
                                        <td>
                                            ${position.maxCandidates}
                                        </td>
                                        <td>
                                            ${position.user.firstName} ${position.user.lastName}  
                                        </td>
                                        <td>
                                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/DetailsPosition?positionId=${position.id}" role="button">Details</a>
                                        </td>
                                        <c:if test = "${  pageContext.request.isUserInRole('RecruiterRole') || 
                                                          pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                                          pageContext.request.isUserInRole('DirectorHRRole') || 
                                                          pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                                              <td>
                                                  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditPosition?positionId=${position.id}" role="button">Edit</a>
                                              </td>
                                        </c:if>
                                        <c:if test = "${position.state eq 'Active' && (pageContext.request.isUserInRole('RecruiterRole')|| 
                                                                                       pageContext.request.isUserInRole('DirectorGeneralRole'))}">
                                            <td>
                                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/AddCandidate?positionId=${position.id}" role="button">Add Candidate</a>
                                            </td>
                                        </c:if>
                                        <c:if test="${position.state eq 'Inactive' && pageContext.request.isUserInRole('DirectorGeneralRole')}">
                                            <td>
                                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ActivatePosition?positionId=${position.id}" role="button">Activate</a>
                                            </td>
                                        </c:if> 
                                        <c:if test="${position.state eq 'Closed' && pageContext.request.isUserInRole('DirectorGeneralRole')}">
                                            <td>
                                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ReactivatePosition?positionId=${position.id}" role="button">Reactivate</a>
                                            </td>
                                        </c:if>
                                        <c:if test = "${(position.state eq 'Inactive' || position.state eq 'Active') && (pageContext.request.isUserInRole('DirectorGeneralRole'))}">
                                            <td>
                                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ClosePosition?positionId=${position.id}" role="button">Close</a>
                                            </td>
                                        </c:if>
                                </c:when>
                                <c:when test = "${not pageContext.request.isUserInRole('')}">
                                    <c:if test = "${(position.state eq 'Active')}">
                                        <td>
                                            ${position.name}
                                        </td>
                                        <td>
                                            ${position.maxCandidates}
                                        </td> 
                                        <td>
                                            ${position.user.firstName} ${position.user.lastName}
                                        </td>
                                        <td>
                                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/DetailsPosition?positionId=${position.id}" role="button">Details</a>
                                        </td>
                                    </c:if>
                                </c:when>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</t:pageTemplate>