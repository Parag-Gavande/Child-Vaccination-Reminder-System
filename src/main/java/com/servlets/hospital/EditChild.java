package com.servlets.hospital;

import com.dao.ChildDAO;
import com.entity.Child;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class EditChild extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        ChildDAO childDAO = new ChildDAO();
        Child child = childDAO.getChildById(Id);

        if (child != null) {
            request.setAttribute("child", Child);
            request.getRequestDispatcher("edit_child.jsp").forward(request, response);
        } else {
            response.sendRedirect("ViewChildren");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        String childName = request.getParameter("ChildName");
        String parentName = request.getParameter("ParentName");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String parentContact = request.getParameter("parentContact");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Child child = new Child();
        child.setId(id);
        child.setChildName(childName);
        child.setParentName(parentName);
        child.setDob(dob);
        child.setParentContact(parentContact);
        child.setEmail(email);
        child.setAddress(address);

        ChildDAO childDAO = new ChildDAO();
        childDAO.updateChild(child); 

        response.sendRedirect("ViewChild.java");
    }
}
