package com.servlets.hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.VaccineDAO;
import com.entity.Vaccine;

public class EditVaccine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("Id");
        int id = 0;
        if (idParam != null && !idParam.isEmpty()) {
            try {
                id = Integer.parseInt(idParam);
            } catch (NumberFormatException e) {
                response.sendRedirect(); 
                return;
            }
        }

        VaccineDAO vaccineDAO = new VaccineDAO();
        Vaccine vaccine = vaccineDAO.getVaccineById(id);

        if (vaccine != null) {
            request.setAttribute("vaccine", vaccine);
            request.getRequestDispatcher("edit_vaccine.jsp").forward(request, response);
        } else {
            response.sendRedirect(); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        String vaccineName = request.getParameter("vaccinename");
        String vaccineDetails = request.getParameter("vaccinedetails");
        double price = Double.parseDouble(request.getParameter("price"));
        int months = Integer.parseInt(request.getParameter("months"));

        Vaccine vaccine = new Vaccine();
        vaccine.setId(id);
        vaccine.setVaccineName(vaccineName);
        vaccine.setVaccineDetails(vaccineDetails);
        vaccine.setPrice(price);
        vaccine.setMonths(months);

        VaccineDAO vaccineDAO = new VaccineDAO();
        vaccineDAO.updateVaccine(vaccine);

        response.sendRedirect();
    }
}
