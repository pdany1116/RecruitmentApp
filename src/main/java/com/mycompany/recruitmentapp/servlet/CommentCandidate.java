/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.CandidateDetails;
import com.mycompany.recruitmentapp.ejb.CandidateBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucis
 */
@WebServlet(name = "CommentCandidate", urlPatterns = {"/CommentCandidate"})
public class CommentCandidate extends HttpServlet {

    @Inject
    private CandidateBean candidateBean;
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentCandidate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentCandidate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //candidateId = Integer.parseInt(request.getParameter("id"));
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int candidateId = Integer.parseInt(request.getParameter("id"));
        CandidateDetails candidate = candidateBean.findById(candidateId);
        String oldComment = candidate.getComment();
        String newComment;
        String readComment = request.getParameter("comment");
        newComment = oldComment + "<br> \" - " + readComment + "\" written by <b> "+ request.getRemoteUser() +"</b>";
        
      
        candidateBean.updateComment(candidateId, newComment);
        
        response.sendRedirect(request.getContextPath() + "/Positions");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
