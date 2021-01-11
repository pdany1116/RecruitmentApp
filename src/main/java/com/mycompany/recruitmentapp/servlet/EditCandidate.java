package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.CandidateDetails;
import com.mycompany.recruitmentapp.ejb.CandidateBean;
import java.io.IOException;
import java.sql.Date;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucis
 */
@DeclareRoles({"RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"RecruiterRole"}))
@WebServlet(name = "EditCandidate", urlPatterns = {"/EditCandidate"})
public class EditCandidate extends HttpServlet {

    @Inject
    CandidateBean candidateBean;

    private String positionId;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int candidateId = Integer.parseInt(request.getParameter("candidateId"));
        positionId = request.getParameter("positionId");
        CandidateDetails candidate = candidateBean.findById(candidateId);
        request.setAttribute("candidate", candidate);
        request.getRequestDispatcher("/WEB-INF/pages/editCandidate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String date = request.getParameter("date");
        Date d = Date.valueOf(date);

        Integer candidateId = Integer.parseInt(request.getParameter("candidateId"));

        candidateBean.updateCandidate(candidateId, firstName, lastName, phone, mail, address, d);

        response.sendRedirect(request.getContextPath() + "/DetailsPosition?positionId=" + positionId);

    }
}
