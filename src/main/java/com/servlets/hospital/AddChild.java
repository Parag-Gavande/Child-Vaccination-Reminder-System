package com.servlets.hospital;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ChildDAO;
import com.entity.Child;

public class AddChild extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String childName = request.getParameter("ChildName");
        String parentName = request.getParameter("ParentName");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String parentContact = request.getParameter("ParentContact");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        String address = request.getParameter("Address");

        Child child = new Child();
        child.setChildName(childName);
        child.setParentName(parentName);
        child.setDob(dob);
        child.setParentContact(parentContact);
        child.setEmail(email);
        child.setPassword(password);
        child.setAddress(address);

        ChildDAO childDAO = new ChildDAO();
        childDAO.addChild(child);

        response.sendRedirect("Viewchild"); 
    }
}
