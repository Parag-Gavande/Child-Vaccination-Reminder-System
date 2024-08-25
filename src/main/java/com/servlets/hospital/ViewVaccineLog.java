package com.servlets.hospital;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.VaccineLogDAO;
import com.entity.VaccineLog;

public class ViewVaccineLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VaccineLogDAO vaccineLogDAO = new VaccineLogDAO();
        List<VaccineLog> vaccineLog = vaccineLogDAO.getAllVaccineLogs();

        request.setAttribute("vaccineLog", vaccineLog);
        request.getRequestDispatcher("view_vaccineLogs.jsp").forward(request, response); 
    }
}
