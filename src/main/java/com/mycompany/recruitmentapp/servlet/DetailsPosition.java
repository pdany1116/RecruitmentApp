package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.PositionDetails;
import com.mycompany.recruitmentapp.ejb.PositionBean;
import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GI
 */
@DeclareRoles({"AdministratorRole", "DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"})
@WebServlet(name = "DetailsPosition", urlPatterns = {"/DetailsPosition"})
public class DetailsPosition extends HttpServlet {

    @Inject
    private PositionBean positionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int positionId = Integer.parseInt(request.getParameter("positionId"));
        PositionDetails position = positionBean.findById(positionId);
        request.setAttribute("positionID", positionId);
        request.setAttribute("position", position);

        request.setAttribute("candidates", position.getCandidates());
        request.getRequestDispatcher("/WEB-INF/pages/detailsPosition.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
