package com.servlets.child;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ChildDAO;
import com.entity.Child;

public class ChildPasswordChange extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the logged-in child from the session
        Child child = (Child) request.getSession().getAttribute("child");
        if (child == null) {
            response.sendRedirect("child_login.jsp");
            return;
        }

        // Get the form parameters
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate the current password
        if (!currentPassword.equals(child.getPassword())) {
            request.setAttribute("error", "Current password is incorrect.");
            request.getRequestDispatcher("child_changePassword.jsp").forward(request, response);
            return;
        }

        // Check if the new password and confirm password match
        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("error", "New passwords do not match.");
            request.getRequestDispatcher("child_changePassword.jsp").forward(request, response);
            return;
        }

        // Update the password
        ChildDAO childDAO = new ChildDAO();
        child.setPassword(newPassword);
        childDAO.childPasswordChange(child);

        // Redirect to dashboard with a success message
        request.getSession().setAttribute("success", "Password changed successfully.");
        response.sendRedirect("child_dashboard.jsp");
    }
}
