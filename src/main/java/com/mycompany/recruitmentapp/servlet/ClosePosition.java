package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.ejb.PositionBean;
import java.io.IOException;
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
 * @author GI
 */
@DeclareRoles({"DirectorGeneralRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole"}))
@WebServlet(name = "ClosePosition", urlPatterns = {"/ClosePosition"})
public class ClosePosition extends HttpServlet {

    @Inject
    private PositionBean positionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int positionId = Integer.parseInt(request.getParameter("positionId"));
        positionBean.updatePositionState(positionId, "Closed");
        response.sendRedirect(request.getContextPath() + "/Positions");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
