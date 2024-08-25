package com.servlets.hospital;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ChildDAO;
import com.dao.VaccineLogDAO;
import com.entity.Child;
import com.entity.VaccineLog;

public class AddVaccineLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int childId = Integer.parseInt(request.getParameter("childId"));
        String vaccineName = request.getParameter("vaccineName");
        Date date = Date.valueOf(request.getParameter("date"));
        int ageMonths = Integer.parseInt(request.getParameter("ageMonths"));

        ChildDAO childDAO = new ChildDAO();
        Child child = childDAO.getChildById(childid);

        if (child != null) {
            VaccineLog vaccineLog = new VaccineLog();
            vaccineLog.setChild(child);
            vaccineLog.setVaccineName(vaccineName);
            vaccineLog.setDate(date);
            vaccineLog.setAgeMonths(ageMonths);

            VaccineLogDAO vaccineLogDAO = new VaccineLogDAO();
            vaccineLogDAO.addVaccineLog(vaccineLog);

            response.sendRedirect("ViewVaccineLog.jsp"); 
        } else {
            request.setAttribute("errorMessage", "Invalid Child ID. Please enter a valid ID.");
            request.getRequestDispatcher("addVaccineLog").forward(request, response); 
        }
    }
}
