package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.UserDetails;
import com.mycompany.recruitmentapp.ejb.UserBean;
import com.mycompany.recruitmentapp.util.PasswordUtil;
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
 * @author lucis
 */
@DeclareRoles({"AdministratorRole", "DirectorGeneralRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdministratorRole", "DirectorGeneralRole"}))
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String internalFunction = request.getParameter("internalFunction");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String username;
        int i = 1;
        if (lastName.length() >= 4) {
            username = lastName.substring(0, 4) + firstName.substring(0, i);
        } else {
            username = lastName + firstName.substring(0, i);
        }

        List<UserDetails> users = userBean.getAllUsers();
        for (UserDetails user : users) {
            if (user.getUsername().equals(username) && i < firstName.length()) {
                i++;
                if (lastName.length() >= 4) {
                    username = lastName.substring(0, 4) + firstName.substring(0, i);
                } else {
                    username = lastName + firstName.substring(0, i);
                }
            }
        }

        String passwordSha256 = PasswordUtil.convertToSha256(password);

        userBean.createUser(description, firstName, lastName, internalFunction, phone, email, passwordSha256, position, username);

        response.sendRedirect(request.getContextPath() + "/Users");
    }
}
