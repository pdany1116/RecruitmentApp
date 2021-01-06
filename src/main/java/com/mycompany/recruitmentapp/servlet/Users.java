/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@DeclareRoles({"AdministratorRole"})
@ServletSecurity(value = @HttpConstraint( 
                                    rolesAllowed = {"AdministratorRole"}))

@WebServlet(name = "Users", urlPatterns = {"/Users"})
public class Users extends HttpServlet {

    @Inject
    private UserBean userBean;
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String [] userIdsAsString = request.getParameterValues("user_ids");
        if( userIdsAsString != null) {
            List<Integer> userIds = new ArrayList<> ();
            for(String userIdAsString : userIdsAsString){
                userIds.add(Integer.parseInt(userIdAsString));                
            }
            userBean.deleteUsersByIds(userIds);
        }
        response.sendRedirect(request.getContextPath() + "/Users");
        
        
        
        
        }

}
