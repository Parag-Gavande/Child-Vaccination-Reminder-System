package com.servlets.child;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ChildDAO;
import com.entity.Child;

public class ChildLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        ChildDAO childDAO = new ChildDAO();
        Child child = childDAO.getChildByEmail(Email); 

        if (child != null && child.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("child", child); 
            response.sendRedirect("ChildUpcomingVaccine.java"); 
        } else {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("child_login.jsp").forward(request, response); 
        }
    }
}
