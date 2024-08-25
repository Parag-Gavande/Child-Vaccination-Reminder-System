package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.configuration.HibernateConfiguration;
import com.entity.Hospital;
public class HospitalDAO {
	
	Session session=null;


    public void updateHospital(Hospital hospital) {
    	session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(hospital);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
