<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Candidate">
    <h1> Add Candidate </h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCandidate">
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
                <label for="mail">Email</label>
                <input type="email" class="form-control" id="mail" name="mail" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Email is required
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Address is required
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
                <label for="date">Date</label>
                <input type="date" class="form-control" id="date" name="date" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Date is required
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="comment">Comments</label>
                <input type="text" class="form-control" id="comment" name="comment" placeholder="" value="" required><!-- comment -->
                <div class="invalid-feedback">
                    Comment is required
                </div>
            </div>
        </div>
         
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cv"> CV</label><!-- comment -->
                <input type="file" name="cv"><!-- comment -->
                <div class="invalid-feedback">
                    CV is required.
                </div>
            </div>
        </div>
        
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button><!-- comment -->
    </form>
        
</t:pageTemplate>