package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.UserBean;
import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

/**
 *
 * @author Claudia
 */
@DeclareRoles({"AdministratorRole", "DirectorGeneralRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdministratorRole", "DirectorGeneralRole"}))
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        UserDetails user = userBean.findById(userId);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String description = request.getParameter("description");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String internalFunction = request.getParameter("internalFunction");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");

        String email = request.getParameter("email");
        Integer userId = Integer.parseInt(request.getParameter("user_id"));

        userBean.updateUser(userId, description, firstName, lastName, email, internalFunction, phone, position);

        response.sendRedirect(request.getContextPath() + "/Users");
    }
}
