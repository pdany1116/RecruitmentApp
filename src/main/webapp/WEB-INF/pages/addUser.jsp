<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add User">
    <h1 style="padding-left: 650px;"> Add User </h1>
    <div style="padding-left: 500px;">
        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddUser">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Firstname</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Firstname is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Lastname</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Lastname is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Email is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="internalFunction">Internal Function</label>
                        <input type="text" class="form-control" id="internalFunction" name="internalFunction" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Internal function is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="phone">Phone number</label>
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Phone number is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="description">Description</label>
                        <input type="text" class="form-control" id="description" name="description" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Description is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="" value="" required><!-- comment -->
                        <div class="invalid-feedback">
                            Password is required
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="position">Position</label>
                        <select class="custom-select d-block w-100" id="position" name="position" required>
                            <option value="">Choose...</option><!-- comment -->
                            <option value="ADMINISTRATOR">Administrator</option><!-- comment -->
                            <option value="DIRECTOR_GENERAL">Director General</option>
                            <option value="DIRECTOR_DEPARTAMENT">Director Departament</option>
                            <option value="DIRECTOR_HR">Director HR</option><!-- comment -->
                            <option value="RECRUITER">Recruiter</option><!-- comment --><!-- comment -->
                        </select>
                        <div class="invalid-feedback">
                            Please select a position.
                        </div>
                    </div>
                </div>

                <div style="padding-left: 70px;" >
                    <div class="col-md-4 ">
                        <button class="btn btn-primary  btn-block" type="submit">Save</button>
                    </div>
                </div>  
            </div>        
        </form>
    </div>    
</t:pageTemplate>