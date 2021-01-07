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
           
            <h3>Candidati pentru pozitie</h3>
                
    
    <c:forEach var = "candidate" items = "${candidates}" varStatus = "status">
        <div class = "row">
            <div class ="col-md-1">
                ${candidate.firstName}
            </div>
            <div class ="col-md-1">
                ${candidate.lastName}
            </div>
            <div class="col-md-3">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCandidate?id=${canditate.id}" role="button"> Edit Candidate</a>
            </div>
            <div class="col-md-3">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/DeleteCanditate?id=${candidate.id}" role="button"> Delete Candidate</a>
            </div> 
        </div>
    </c:forEach>
</t:pageTemplate>