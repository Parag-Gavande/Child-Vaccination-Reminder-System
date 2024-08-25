package com.servlets.hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HibernateConfiguration;
import com.entity.Hospital;

public class HospitalLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (validLogin(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("hospitalEmail", "pra@gmail.com");
            response.sendRedirect("Upcomingvaccine");
        } else {
            response.sendRedirect("hospitallogin.jsp");
        }
    }

    private boolean validLogin(String email, String password) {
        Session session = null;
        Transaction transaction = null;
        boolean isValid = false;

        try {
            // Open a Hibernate session
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Query to find the hospital by email and password
            String hql = "FROM Hospital WHERE Email = :Email AND Password = :Password";
            Query<Hospital> query = session.createQuery(hql, Hospital.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            // Check if any result is returned
            isValid = query.uniqueResult() != null;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return null;
    }
}
