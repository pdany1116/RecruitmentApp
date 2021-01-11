package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.PositionDetails;
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
@DeclareRoles({"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"}))
@WebServlet(name = "EditPosition", urlPatterns = {"/EditPosition"})
public class EditPosition extends HttpServlet {

    @Inject
    PositionBean positionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int positionId = Integer.parseInt(request.getParameter("positionId"));
        PositionDetails position = positionBean.findById(positionId);
        request.setAttribute("position", position);
        request.getRequestDispatcher("/WEB-INF/pages/editPosition.jsp").forward(request, response);
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
        Integer positionId = Integer.parseInt(request.getParameter("position_id"));

        positionBean.updatePosition(positionId, name, department, project, requirements, responsibilities, maxCandidates, state, positionId);

        response.sendRedirect(request.getContextPath() + "/Positions");
    }
}
