/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.ejb.PositionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dani
 */
@WebServlet(name = "AddPosition", urlPatterns = {"/AddPosition"})
public class AddPosition extends HttpServlet {
    
    @Inject
    PositionBean positionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String state = "Inactive";
        Integer maxCandidates = Integer.parseInt(request.getParameter("maxCandidates"));
        //Integer userId = Integer.parseInt(request.getParameter("userId"));
        
        //positionBean.LOG.info("ID ID ID ID ID = " + request.getSession().getAttribute("username"));
        //positionBean.createPosition(name, department, project, requirements, responsibilities, maxCandidates, userId);
        response.sendRedirect(request.getContextPath()+ "/Positions");
    }
}
