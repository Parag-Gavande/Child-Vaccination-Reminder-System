package com.servlets.hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VaccineDAO;
import com.entity.Vaccine;

public class AddVaccine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VaccineDAO vaccineDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        vaccineDAO = new VaccineDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vaccineName = request.getParameter("VaccineName");
        String vaccineDetails = request.getParameter("VaccineDetails");
        double price = Double.parseDouble(request.getParameter("price"));
        int months = Integer.parseInt(request.getParameter("months"));

        Vaccine vaccine = new Vaccine();
        vaccine.setVaccineName(vaccineName);
        vaccine.setVaccineDetails(vaccineDetails);
        vaccine.setPrice(price);
        vaccine.setMonths(months);

        try {
            vaccineDAO.addVaccine(vaccine);
            response.sendRedirect("Viewvaccines"); 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding vaccine: " + e.getMessage());
        }
    }
}
