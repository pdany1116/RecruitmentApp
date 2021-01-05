<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add User">
    <h1> Add User </h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddUser">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstname">Firstname</label>
                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Firstname is required
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastname">Lastname</label>
                <input type="text" class="form-control" id="lastname" name="lastname" placeholder="" value="" required><!-- comment -->
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
                <label for="internalfunction">Internal function</label>
                <input type="text" class="form-control" id="internalfunction" name="internalfunction" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Internal function is required
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
                    Phone number is required
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
        
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button><!-- comment -->
    </form>
        
</t:pageTemplate>