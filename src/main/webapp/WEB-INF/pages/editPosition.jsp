<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Position">
    <h1 style="padding-left: 650px;"> Edit Position </h1>
    <div style="padding-left: 500px;">
        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditPosition">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${position.name}" required><!-- comment -->
                        <div class="invalid-feedback">
                            Name is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="department">Department</label>
                        <input type="text" class="form-control" id="department" name="department" placeholder="Department" required value="${position.department}" ><!-- comment -->
                        <div class="invalid-feedback">
                            Department is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="project">Project</label>
                        <input type="text" class="form-control" id="project" name="project" placeholder="Project" value="${position.project}" required><!-- comment -->
                        <div class="invalid-feedback">
                            Project is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="requirements">Requirements</label>
                        <input type="text" class="form-control" id="requirements" name="requirements" placeholder="Requirements" value="${position.requirements}" required><!-- comment -->
                        <div class="invalid-feedback">
                            Requirements is required
                        </div>
                    </div>
                </div>  

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="responsibilities">Responsibilities</label>
                        <input type="text" class="form-control" id="responsibilities" name="responsibilities" placeholder="Responsibilities" value="${position.responsibilities}" required><!-- comment -->
                        <div class="invalid-feedback">
                            Responsibilities are required
                        </div>
                    </div>
                </div>        

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="maxCandidates">Max candidates</label>
                        <input type="integer" class="form-control" id="maxCandidates" name="maxCandidates" placeholder="max candidates" value="${position.maxCandidates}" required><!-- comment -->
                        <div class="invalid-feedback">
                            Max candidates is required
                        </div>
                    </div>
                </div>

                <input type="hidden" name="position_id" value="${position.id}" />      
                <div style="padding-left: 70px;" >
                    <div class="col-md-4 ">
                        <button class="btn btn-primary  btn-block" type="submit">Save</button>
                    </div>
                </div>    
            </div>
        </form>
    </div>
</t:pageTemplate>     