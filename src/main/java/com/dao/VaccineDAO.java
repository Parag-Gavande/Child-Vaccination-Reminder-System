package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HibernateConfiguration;
import com.entity.Vaccine;

public class VaccineDAO {

    public void addVaccine(Vaccine vaccine) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(vaccine);
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
    }
    
    public List<Vaccine> getAllVaccines() {
        Session session = null;
        List<Vaccine> vaccines = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Query<Vaccine> query = session.createQuery("from Vaccine", Vaccine.class);
            vaccines = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return vaccines;
    }
    
    public void updateVaccine(Vaccine vaccine) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(vaccine);
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
    }
    
    public Vaccine getVaccineById(int id) {
        Session session = null;
        Vaccine vaccine = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            vaccine = session.get(Vaccine.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return vaccine;
    }
    
    public void deleteVaccine(int id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Vaccine vaccine = session.get(Vaccine.class, id);
            if (vaccine != null) {
                session.delete(vaccine);
            }
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
    }

}
