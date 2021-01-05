/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.UserBean;
import com.mycompany.recruitmentapp.entity.User;
import com.mycompany.recruitmentapp.util.PasswordUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {

    
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String internalfunction = request.getParameter("internalfunction");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        int i=1;
        String username = lastname.substring(0,4) + firstname.substring(0,i);
        
        List<UserDetails> users = userBean.getAllUsers();
        for(UserDetails user:users){
            if( user.getUsername().equals(username) && i < firstname.length() )
            {  i++;
               username = lastname.substring(0,4) + firstname.substring(0,i);
               
            } 
        }
        
        
        String passwordSha256 = PasswordUtil.convertToSha256(password);
        
        userBean.createUser(description, firstname, lastname, internalfunction, phone, email, passwordSha256, position, username);
       
        response.sendRedirect(request.getContextPath()+ "/Users");
    }
}
