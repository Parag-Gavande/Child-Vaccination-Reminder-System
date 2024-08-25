package com.servlets.hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.VaccineDAO;

public class DeleteVaccine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("Id");

        if (id != null && !id.isEmpty()) {
            VaccineDAO vaccineDAO = new VaccineDAO();
            vaccineDAO.deleteVaccine(Integer.parseInt(id));
        }

        response.sendRedirect("ViewVaccines");
    }
}
