/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.UserBean;
import com.mycompany.recruitmentapp.util.PasswordUtil;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJBException;

/**
 *
 * @author Claudia
 */
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {
    
     @Inject
    UserBean userBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // List < UserDetails > users = userBean.getAllUsers();
       // request.setAttribute("users", users);
        
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findById(userId);
        request.setAttribute("user", user);
        
        
        request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
        
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
      
        String email = request.getParameter("email");
        Integer userId = Integer.parseInt(request.getParameter("user_id"));
        
       
        
        

        
        
        userBean.updateUser(userId, description, firstname, lastname, email, internalfunction, phone, position);
        
        response.sendRedirect(request.getContextPath() + "/Users");
}

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
