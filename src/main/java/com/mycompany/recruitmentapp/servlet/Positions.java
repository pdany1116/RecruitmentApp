/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.PositionDetails;
import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.PositionBean;
import com.mycompany.recruitmentapp.ejb.UserBean;
import java.io.IOException;
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
 * @author Dani
 */
@DeclareRoles({"AdministratorRole", "DirectorGeneralRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdministratorRole", "DirectorGeneralRole"}))

@WebServlet(name = "Positions", urlPatterns = {"/Positions"})
public class Positions extends HttpServlet {

    @Inject
    private PositionBean positionBean;
    
    @Inject
    UserBean userBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PositionDetails> positions = positionBean.getAllPositions();
        request.setAttribute("positions", positions);
        
        String username = request.getRemoteUser();
        List<UserDetails> users = userBean.getAllUsers();

        for (UserDetails user : users) {
            if (username.equals(user.getUsername())) {
                request.setAttribute("loggedId", user.getId());
            }
        }
        request.getRequestDispatcher("/WEB-INF/pages/positions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
