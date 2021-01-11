package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.ejb.CandidateBean;
import java.io.IOException;
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
@DeclareRoles({"DirectorGeneralRole","RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole","RecruiterRole"}))
@WebServlet(name = "DeleteCandidate", urlPatterns = {"/DeleteCandidate"})
public class DeleteCandidate extends HttpServlet {

    @Inject
    CandidateBean candidateBean;
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {           
            int candidateId = Integer.parseInt(request.getParameter("candidateId"));            
            Integer positionId = Integer.parseInt(request.getParameter("positionId"));        
            candidateBean.deleteCandidateById(candidateId, positionId);        
            response.sendRedirect(request.getContextPath() + "/DetailsPosition?positionId=" + positionId);
    }
}
