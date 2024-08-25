package com.servlets.hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.HospitalDAO;
import com.entity.Hospital;

public class HospitalPasswordChange extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        String email = (String) request.getSession().getAttribute("hospitalEmail"); // Assuming hospital email is stored in session

        if (email == null) {
            response.sendRedirect("hospitalLogin.jsp"); 
            return;
        }

        HospitalDAO hospitalDAO = new HospitalDAO();
        Hospital hospital = hospitalDAO.getHospitalByEmail(email);

        if (hospital != null && hospital.getPassword().equals(oldPassword)) {
            if (newPassword.equals(confirmPassword)) {
                hospital.setPassword(newPassword);
                hospitalDAO.updateHospital(hospital);
                request.setAttribute("successMessage", "Password changed successfully.");
            } else {
                request.setAttribute("errorMessage", "New passwords do not match.");
            }
        } else {
            request.setAttribute("errorMessage", "Old password is incorrect.");
        }

        request.getRequestDispatcher("hospital_changePassword.jsp").forward(request, response);
    }
}
