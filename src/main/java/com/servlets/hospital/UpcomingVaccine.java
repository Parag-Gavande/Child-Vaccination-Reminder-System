package com.servlets.hospital;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.VaccineLogDAO;
import com.entity.VaccineLog;

public class UpcomingVaccine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VaccineLogDAO vaccineLogDAO = new VaccineLogDAO();
        Date today = new Date(System.currentTimeMillis());
        Date next30Days = new Date(today.getTime() + (1000L * 60 * 60 * 24 * 30)); 
        
        List<VaccineLog> upcomingVaccines = vaccineLogDAO.getUpcomingVaccines(today, next30Days); 

        request.setAttribute("upcomingVaccines.jsp", upcomingVaccines);
        request.getRequestDispatcher("upcomingVaccine.jsp").forward(request, response); 
    }
}
