/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.PositionBean;
import com.mycompany.recruitmentapp.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
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
 * @author Dani
 */
@DeclareRoles({"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"}))
@WebServlet(name = "AddPosition", urlPatterns = {"/AddPosition"})
public class AddPosition extends HttpServlet {
    
    @Inject
    private PositionBean positionBean;
        
    private int userId;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userId = Integer.parseInt(request.getParameter("loggedId"));
        request.getRequestDispatcher("/WEB-INF/pages/addPosition.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String project = request.getParameter("project");
        String requirements = request.getParameter("requirements");
        String responsibilities = request.getParameter("responsibilities");
        Integer maxCandidates = Integer.parseInt(request.getParameter("maxCandidates"));
        positionBean.createPosition(name, department, project, requirements, responsibilities, maxCandidates, new Integer(userId));
        response.sendRedirect(request.getContextPath()+ "/Positions");
    }
}
