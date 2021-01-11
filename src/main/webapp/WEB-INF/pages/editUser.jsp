<%-- 
    Document   : editUser
    Created on : Jan 6, 2021, 1:16:55 PM
    Author     : Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add User">
    <h1 style="padding-left: 650px;"> Edit User </h1>
    <div style="padding-left: 500px;">
        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
        <div class="container">
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName">Firstname</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First name" required value="${user.firstName}" ><!-- comment -->
                    <div class="invalid-feedback">
                        Firstname is required
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="lastName">Lastname</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last name" value="${user.lastName}" required><!-- comment -->
                    <div class="invalid-feedback">
                       Lastname is required
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${user.email}" required><!-- comment -->
                    <div class="invalid-feedback">
                        Email is required
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="internalFunction">Internal Function</label>
                    <input type="text" class="form-control" id="internalFunction" name="internalFunction" placeholder="Internal function" value="${user.internalFunction}" required><!-- comment -->
                    <div class="invalid-feedback">
                        Internal function is required
                    </div>
                </div>
            </div>



            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="phone">Phone number</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone Number" value="${user.phone}" required><!-- comment -->
                    <div class="invalid-feedback">
                        Phone number is required
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" placeholder="Description" value="${user.description}" required><!-- comment -->
                    <div class="invalid-feedback">
                        Description is required
                    </div>
                </div>
            </div>

             <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="position">Position</label>
                    <select class="custom-select d-block w-100" id="position" name="position"  required>
                        <option value="${user.position}">${user.position}</option><!-- comment -->
                        <option value="ADMINISTRATOR">ADMINISTRATOR</option><!-- comment -->
                        <option value="DIRECTOR_GENERAL">DIRECTOR_GENERAL</option>
                        <option value="DIRECTOR_DEPARTAMENT">DIRECTOR_DEPARTAMENT</option>
                        <option value="DIRECTOR_HR">DIRECTOR_HR</option><!-- comment -->
                        <option value="RECRUITER">RECRUITER</option><!-- comment --><!-- comment -->
                    </select>
                    <div class="invalid-feedback">
                        Please select a position.
                    </div>
                </div>
            </div>

            <input type="hidden" name="user_id" value="${user.id}" />        
                    <div style="padding-left: 70px;" >
                        <div class="col-md-4 ">
                            <button class="btn btn-primary  btn-block" type="submit">Save</button>
                        </div>
                    </div>  
        </div>
        </form>
    </div>
    
    
    
</t:pageTemplate>    