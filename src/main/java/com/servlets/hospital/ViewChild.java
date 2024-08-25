package com.servlets.hospital;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.ChildDAO;
import com.entity.Child;

public class ViewChild extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChildDAO childrenDAO = new ChildDAO();
        List<Child> childrens = childrenDAO.getAllChildren();
        request.setAttribute("childrens", childrens);
        request.getRequestDispatcher("view_children.jsp").forward(request, response);
    }
}
