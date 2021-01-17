package com.mycompany.recruitmentapp.servlet;

import com.mycompany.recruitmentapp.common.CandidateDetails;
import com.mycompany.recruitmentapp.ejb.CandidateBean;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
@DeclareRoles({"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"DirectorGeneralRole", "DirectorHRRole", "DirectorDepartamentRole", "RecruiterRole"}))
@WebServlet(name = "ViewCV", urlPatterns = {"/ViewCV"})
public class ViewCV extends HttpServlet {

    @Inject
    CandidateBean candidateBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CandidateDetails candidate = candidateBean.findById(id);
        
        if (candidate.getCv().getFileContent() != null) {
            response.setContentType(candidate.getCv().getFileType());
            response.setContentLength(candidate.getCv().getFileContent().length);
            response.getOutputStream().write(candidate.getCv().getFileContent());

            PrintWriter out = response.getWriter();
            FileInputStream fileInputStream = new FileInputStream(candidate.getCv().getFileName());

            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
