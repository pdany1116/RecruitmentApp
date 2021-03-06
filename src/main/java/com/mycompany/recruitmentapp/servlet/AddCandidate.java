package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.CandidateDetails;
import com.mycompany.recruitmentapp.ejb.CandidateBean;
import com.mycompany.recruitmentapp.ejb.PositionBean;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author lucis
 */
@MultipartConfig
@DeclareRoles({"DirectorGeneralRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole", "RecruiterRole"}))
@WebServlet(name = "AddCandidate", urlPatterns = {"/AddCandidate"})
public class AddCandidate extends HttpServlet {

    @Inject
    private CandidateBean candidateBean;

    private int positionId;

    @Inject
    private PositionBean positionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        positionId = Integer.parseInt(request.getParameter("positionId"));
        request.getRequestDispatcher("/WEB-INF/pages/addCandidate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Date date = Date.valueOf(request.getParameter("date"));
        String comment = request.getParameter("comment");
        String newComment = "\" - " + comment + "\" written by <b> " + request.getRemoteUser() + "</b>";

        Part filePart = request.getPart("cv");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        candidateBean.createCandidate(firstName, lastName, phone, mail, address, newComment, date, positionId, fileName, fileType, fileContent);

        int takenPositions = 0;
        int maxPositions = positionBean.findById(positionId).getMaxCandidates();
        List<CandidateDetails> candidates = candidateBean.getAllCandidates();

        for (CandidateDetails candidate : candidates) {
            if (candidate.getPosition().getId().equals(positionId)) {
                takenPositions++;
            }
        }

        if (takenPositions == maxPositions) {
            positionBean.updatePositionState(positionId, "Closed");
        }
        response.sendRedirect(request.getContextPath() + "/Positions");
    }
}
