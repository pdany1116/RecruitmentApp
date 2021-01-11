<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <div class="container">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Project</th>
                        <th>Requirements</th>
                        <th>Responsibilities</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> ${position.name} </td>
                        <td> ${position.department} </td>
                        <td> ${position.project} </td>
                        <td> ${position.requirements} </td>
                        <td> ${position.responsibilities} </td>
                    </tr>   
                </tbody>
            </table>
        </div>
        <c:if test ="${  pageContext.request.isUserInRole('RecruiterRole') || 
                         pageContext.request.isUserInRole('DirectorGeneralRole') ||
                         pageContext.request.isUserInRole('DirectorHRRole') || 
                         pageContext.request.isUserInRole('DirectorDepartamentRole') ||
                         pageContext.request.isUserInRole('AdministratorRole')}">        
              <h3>Candidates for position</h3>

              <div class="table-responsive">
                  <table class="table">
                      <thead>
                          <tr>
                              <th>First Name</th>
                              <th>Last Name</th>
                              <th>Comments</th>
                          </tr>
                      </thead>
                      <tbody>
                          <c:forEach var = "candidate" items = "${candidates}" varStatus = "status">
                              <tr>
                                  <td> ${candidate.firstName} </td>
                                  <td> ${candidate.lastName} </td>
                                  <td>  ${candidate.comment} </td>
                                  <c:if test ="${pageContext.request.isUserInRole('RecruiterRole') || 
                                                 pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                                 pageContext.request.isUserInRole('DirectorHRRole') || 
                                                 pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                                        <td>
                                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/DetailsCandidate?candidateId=${candidate.id}" role="button"> Details </a>
                                        </td>    
                                  </c:if>
                                  <c:if test ="${pageContext.request.isUserInRole('RecruiterRole') || 
                                                 pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                                 pageContext.request.isUserInRole('DirectorHRRole') || 
                                                 pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                              <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/CommentCandidate?id=${candidate.id}">
                                  <td><input type="text" class="form-control" id="comment" name="comment" placeholder="" value="" required>
                                      <input type="hidden" id="positionId" name="positionId" value="${positionID}">
                                      <button class="btn btn-secondary btn-block" type="submit">Add comment</button> </td>
                              </form> 
                          </c:if>
                          <c:if test ="${  pageContext.request.isUserInRole('RecruiterRole')}">
                              <td>
                                  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCandidate?candidateId=${candidate.id}&positionId=${positionID}" role="button"> Edit </a>
                              </td>
                          </c:if>
                          <c:if test ="${  pageContext.request.isUserInRole('RecruiterRole') && position.state eq 'Active' }">
                              <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/DeleteCandidate?candidateId=${candidate.id}">
                                  <input type="hidden" id="positionId" name="positionId" value="${positionID}">
                                  <td> <button class="btn btn-secondary btn-block" type="submit">Delete</button> </td>
                              </form> 
                          </c:if>
                          <c:if test ="${pageContext.request.isUserInRole('RecruiterRole') || 
                                         pageContext.request.isUserInRole('DirectorGeneralRole') ||
                                         pageContext.request.isUserInRole('DirectorHRRole') || 
                                         pageContext.request.isUserInRole('DirectorDepartamentRole')}">
                                <td>
                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ViewCV?id=${candidate.id}" role="button"> View CV</a>
                                </td> 
                          </c:if>
                          </tr>
                          </form> 
                      </c:forEach>
                      </tbody>
                  </table>
              </div>
        </c:if>
    </div>
</t:pageTemplate>