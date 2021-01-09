/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.CandidateDetails;
import com.mycompany.recruitmentapp.ejb.CandidateBean;
import com.mycompany.recruitmentapp.ejb.PositionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
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
@WebServlet(name = "AddCandidate", urlPatterns = {"/AddCandidate"})
public class AddCandidate extends HttpServlet {

    @Inject
    private CandidateBean candidateBean;
    
    private int positionId;
    
    @Inject
    private PositionBean positionBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCandidate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCandidate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        positionId = Integer.parseInt(request.getParameter("positionId"));
        request.getRequestDispatcher("/WEB-INF/pages/addCandidate.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Date date = Date.valueOf(request.getParameter("date"));
        String comment = request.getParameter("comment");
        String newComment =  "\" - " + comment + "\" written by <b> "+ request.getRemoteUser() +"</b>";
        String cv = request.getParameter("cv");
        
        
        candidateBean.createCandidate(firstName, lastName, phone, mail, address, cv, newComment, date, positionId);
        
        int takenPositions = 0;
        int maxPositions = positionBean.findById(positionId).getMaxCandidates();
        List<CandidateDetails> candidates = candidateBean.getAllCandidates();
        
        for(CandidateDetails candidate : candidates){
            if(candidate.getPosition().getId().equals(positionId))
                takenPositions++;
        }
        
        // close position automatically
        if(takenPositions == maxPositions)
            positionBean.updatePositionState(positionId, "Closed");
        
        response.sendRedirect(request.getContextPath() + "/Positions");
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
