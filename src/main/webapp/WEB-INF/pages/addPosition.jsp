<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Position">
    <h1 style="padding-left: 650px;"> Add Position </h1>
    <div style="padding-left: 500px;">
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
                        <!-- <input type="text" class="form-control" id="department" name="department" placeholder="" value="" required> comment -->
                        <select class="custom-select d-block w-100" id="department" name="department" required>
                            <option value="">Choose...</option><!-- comment -->
                            <option value="GBA">GBA</option><!-- comment -->
                            <option value="GBC">GBC</option>
                            <option value="MSA">MSA</option>
                            <option value="MNG">MNG</option><!-- comment -->
                        </select>
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
                <div style="padding-left: 70px;" >
                    <div class="col-md-4 ">
                        <button class="btn btn-primary  btn-block" type="submit">Save</button><!-- comment -->
                    </div>
                </div>
            </div>
        </form>
    </div>   
</t:pageTemplate>
    
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'

            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation')

                // Loop over them and prevent submission
                Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
            }, false)
        })()

    </script>