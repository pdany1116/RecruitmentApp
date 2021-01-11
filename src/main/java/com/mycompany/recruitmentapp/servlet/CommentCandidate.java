package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.CandidateDetails;
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
@DeclareRoles({"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"}))
@WebServlet(name = "CommentCandidate", urlPatterns = {"/CommentCandidate"})
public class CommentCandidate extends HttpServlet {

    @Inject
    private CandidateBean candidateBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int candidateId = Integer.parseInt(request.getParameter("id"));
        CandidateDetails candidate = candidateBean.findById(candidateId);
        String oldComment = candidate.getComment();
        String newComment;
        String readComment = request.getParameter("comment");
        newComment = oldComment + "<br> \" - " + readComment + "\" written by <b> " + request.getRemoteUser() + "</b>";

        String positionId = request.getParameter("positionId");

        candidateBean.updateComment(candidateId, newComment);

        response.sendRedirect(request.getContextPath() + "/DetailsPosition?positionId=" + positionId);
    }
}
