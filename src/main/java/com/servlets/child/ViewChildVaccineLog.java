package com.servlets.child;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VaccineLogDAO;
import com.entity.Child;
import com.entity.VaccineLog;

public class ViewChildVaccineLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Child child = (Child) request.getSession().getAttribute("child");
        if (child == null) {
            response.sendRedirect("child_login.jsp");
            return;
        }
        
        VaccineLogDAO vaccineLogDAO = new VaccineLogDAO();
        
        List<VaccineLog> vaccineLogs = vaccineLogDAO.getVaccineLogsByChildId(child.getId());
        
        request.setAttribute("vaccineLogs", vaccineLogs);
        
        request.getRequestDispatcher("view_child_vaccineLog.jsp").forward(request, response);
    }
}
