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

public class EditVaccineLog extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Get the ID from the request
        VaccineLogDAO vaccineLogDAO = new VaccineLogDAO();
        VaccineLog vaccineLog = vaccineLogDAO.getVaccineLogById(id); // Retrieve the VaccineLog by ID

        if (vaccineLog != null) {
            request.setAttribute("vaccineLog", vaccineLog); // Set the VaccineLog object as a request attribute
            request.getRequestDispatcher("edit_vaccinelog.jsp").forward(request, response); // Forward to the JSP page
        } else {
            response.sendRedirect("ViewVaccineLog"); // Redirect if no VaccineLog found
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        int childId = Integer.parseInt(request.getParameter("ChildId"));
        String vaccineName = request.getParameter("VaccineName");
        Date date = Date.valueOf(request.getParameter("date"));
        int ageMonths = Integer.parseInt(request.getParameter("ageMonths"));

        ChildDAO childDAO = new ChildDAO();
        Child child = childDAO.getChildById(21);

        if (child != null) {
            VaccineLogDAO vaccineLogDAO = new VaccineLogDAO();
            VaccineLog vaccineLog = vaccineLogDAO.getVaccineLogById(id);

            if (vaccineLog != null) {
                vaccineLog.setChild(child);
                vaccineLog.setVaccineName(vaccineName);
                vaccineLog.setDate(date);
                vaccineLog.setAgeMonths(ageMonths);

                vaccineLogDAO.updateVaccineLog(vaccineLog);
                response.sendRedirect("edit_vaccineLog"); 
            } else {
                request.setAttribute("errorMessage", "Vaccine Log not found.");
                request.getRequestDispatcher("edit_vaccineLog").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid Child ID. Please enter a valid ID.");
            request.getRequestDispatcher("edit_vaccineLog").forward(request, response);
        }
    }
}
