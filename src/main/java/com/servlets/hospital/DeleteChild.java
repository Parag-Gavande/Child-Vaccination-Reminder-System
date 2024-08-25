package com.servlets.hospital;

import com.dao.ChildDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteChild extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        
        ChildDAO childDAO = new ChildDAO();
        childDAO.deleteChild(id);

        response.sendRedirect("ViewChild.jsp");
    }
}
