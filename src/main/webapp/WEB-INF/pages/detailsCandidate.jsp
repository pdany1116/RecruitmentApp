<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle = "JT HR Positions">
    <div class="container">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Last Name</th>
                        <th>First Name</th>
                        <th> Phone</th>
                        <th> Email</th>
                        <th>Address</th>
                        <th>Interview Date</th>
                        <th>Comment</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> ${candidate.lastName} </td>
                        <td> ${candidate.firstName}</td>
                        <td> ${candidate.phone} </td>
                        <td> ${candidate.mail} </td>
                        <td> ${candidate.address}</td>
                        <td> ${candidate.interviewDate} </td>
                        <td> ${candidate.comment} </td>
                        <td>
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ViewCV?id=${candidate.id}" role="button"> View CV</a>
                        </td> 
                    </tr>
                </tbody>
            </table>
                
        </div>
    </div>
</t:pageTemplate>
