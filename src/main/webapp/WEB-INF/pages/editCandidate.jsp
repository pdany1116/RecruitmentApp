<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Candidate">
    <h1> Edit Candidate </h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditCandidate">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="${candidate.firstName}" required><!-- comment -->
                <div class="invalid-feedback">
                    First name is required
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="${candidate.lastName}" required><!-- comment -->
                <div class="invalid-feedback">
                    Last name is required
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="mail">Email</label>
                <input type="email" class="form-control" id="mail" name="mail" placeholder="" value="${candidate.mail}" required><!-- comment -->
                <div class="invalid-feedback">
                    Email is required
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="" value="${candidate.address}" required><!-- comment -->
                <div class="invalid-feedback">
                    Address is required
                </div>
            </div>
        </div>



        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="phone">Phone number</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="" value="${candidate.phone}" required><!-- comment -->
                <div class="invalid-feedback">
                    Phone number is required
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="date">Date</label>
                <input type="date" class="form-control" id="date" name="date" placeholder="" value="${candidate.interviewDate}" required><!-- comment -->
                <div class="invalid-feedback">
                    Date is required
                </div>
            </div>
        </div>

      
        <input type="hidden" id="candidateId" name="candidateId" value="${candidate.id}" />  
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button><!-- comment -->
    </form>

</t:pageTemplate>