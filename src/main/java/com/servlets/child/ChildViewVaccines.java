package com.servlets.child;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VaccineDAO;
import com.entity.Vaccine;

/**
 * Servlet implementation class ChildViewVaccines
 */
public class ChildViewVaccines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VaccineDAO vaccineDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        vaccineDAO = new VaccineDAO(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vaccine> vaccine = null;
        
        try {
            vaccines = vaccineDAO.getAllVaccines();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error retrieving vaccines: " + e.getMessage());
        }
        
        request.setAttribute("vaccine", vaccine);
        request.getRequestDispatcher("childViewVaccines.jsp").forward(request, response);
    }

}
