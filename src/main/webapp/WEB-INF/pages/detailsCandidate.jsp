<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <div class="container">
        <div class="row">
            <div> Last Name: </div><!-- comment -->
            <div> ${candidate.lastName} </div>
        </div>

        <div class="row">
            <div> First Name: </div><!-- comment -->
            <div> ${candidate.firstName} </div>
        </div><!-- comment -->

        <div class="row">
            <div> Phone: </div><!-- comment -->
            <div> ${candidate.phone} </div>
        </div><!-- comment -->

        <div class="row">
            <div> Mail: </div><!-- comment -->
            <div> ${candidate.mail} </div>
        </div><!-- comment -->

        <div class="row">
            <div> Address: </div><!-- comment -->
            <div> ${candidate.address} </div>
        </div>

        <div class="row">
            <div> Interview Date: </div><!-- comment -->
            <div> ${candidate.interviewDate} </div>
        </div>

        <div class="row">
            <div> Comment: </div><!-- comment -->
            <div> ${candidate.comment} </div>
        </div>
        
        <div class="row">
                <td>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ViewCV?id=${candidate.id}" role="button"> View CV</a>
                </td> 
        </div>
    </div>
</t:pageTemplate>
