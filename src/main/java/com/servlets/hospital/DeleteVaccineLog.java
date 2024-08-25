package com.servlets.hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VaccineLogDAO;
import com.entity.VaccineLog;

public class DeleteVaccineLog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id")); 
        
        VaccineLogDAO vaccineLogDAO = new VaccinelogDAO();
        VaccineLog vaccineLog = vaccineLogDAO.getVaccineLogById(id); 
        
        if (vaccineLog != null) {
            vaccineLogDAO.deleteVaccineLog(vaccineLog); 
            response.sendRedirect("ViewVaccineLog.jsp");
        } else {
            response.sendRedirect("ViewVaccineLog.jsp"); 
        }
    }
}
