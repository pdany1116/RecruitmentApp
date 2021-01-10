<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Position">
    <h1 class="text-center"> Add Position </h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddPosition">
        <div class="container">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Name is required
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">Department</label>
                <input type="text" class="form-control" id="department" name="department" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                   Department is required
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="project">Project</label>
                <input type="text" class="form-control" id="project" name="project" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Project is required
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="requirements">Requirements</label>
                <input type="text" class="form-control" id="requirements" name="requirements" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Requirements is required
                </div>
            </div>
        </div>
        
         <div class="row">
            <div class="col-md-6 mb-3">
                <label for="responsibilities">Responsibilities</label>
                <input type="text" class="form-control" id="responsibilities" name="responsibilities" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Responsibilities is required
                </div>
            </div>
        </div>
                
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="maxCandidates">Max Candidates</label>
                <input type="number" class="form-control" id="maxCandidates" name="maxCandidates" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    maxCandidates is required
                </div>
            </div>
        </div>
        <p>${userId}</p>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button><!-- comment -->
        </div>
    </form>
        
</t:pageTemplate>