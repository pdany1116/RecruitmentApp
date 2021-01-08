<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <div class = "row">
        <div class ="col-md-4 ">
            ${position.name}
        </div>
    </div>
    <div class = "row">
        <div class ="col-md-4 ">
            ${position.department}
        </div>
    </div>
    <div class = "row">
        <div class ="col-md-4 ">
            ${position.project}
        </div>
    </div><!-- comment -->
    <div class = "row">
        <div class ="col-md-4 ">
            ${position.requirements}
        </div>
    </div>
    <div class = "row">
        <div class ="col-md-4 ">
            ${position.responsibilities}
        </div>
    </div>
    <c:if test ="${  pageContext.request.isUserInRole('RecruiterRole') || 
                     pageContext.request.isUserInRole('DirectorGeneralRole') ||
                     pageContext.request.isUserInRole('DirectorHRRole') || 
                     pageContext.request.isUserInRole('DirectorDepartamentRole') ||
                     pageContext.request.isUserInRole('AdministratorRole')}">        
          <h3>Candidati pentru pozitie</h3>
          <c:forEach var = "candidate" items = "${candidates}" varStatus = "status">
              <div class = "row">
                  <div class ="col-md-1">
                      ${candidate.firstName}
                  </div>
                  <div class ="col-md-1">
                      ${candidate.lastName}
                  </div>
                  <c:if test ="${  pageContext.request.isUserInRole('RecruiterRole')}">
                      <div class="col-md-3">
                          <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCandidate?id=${canditate.id}" role="button"> Edit Candidate</a>
                      </div>
                  </c:if>
                  <c:if test ="${  pageContext.request.isUserInRole('RecruiterRole')}">
                      <div class="col-md-3">
                          <a class="btn btn-secondary" href="${pageContext.request.contextPath}/DeleteCanditate?id=${candidate.id}" role="button"> Delete Candidate</a>
                      </div> 
                  </c:if>
                  <c:if test ="${pageContext.request.isUserInRole('RecruiterRole') || 
                                 pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                 pageContext.request.isUserInRole('DirectorHRRole') || 
                                 pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                        <div class="col-md-3">
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/CommentCanditate?id=${candidate.id}" role="button"> Add Comment</a>
                        </div> 
                  </c:if>
              </div>
          </c:forEach>
    </c:if>
</t:pageTemplate>