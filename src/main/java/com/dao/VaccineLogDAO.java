package com.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HibernateConfiguration;
import com.entity.VaccineLog;

public class VaccineLogDAO {


	public List<VaccineLog> getAllVaccineLogs() {
		Session session = null;
		List<VaccineLog> vaccineLogs = null;
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			Query<VaccineLog> query = session.createQuery("from VaccineLog", VaccineLog.class);
			vaccineLogs = query.list(); // Get the list of all vaccine logs
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return vaccineLogs;
	}

	public List<VaccineLog> getUpcomingVaccines(Date startDate, Date endDate) {
		Session session = null;
		List<VaccineLog> upcomingVaccines = null;
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			Query<VaccineLog> query = session.createQuery("from VaccineLog where date between :startDate and :endDate",
					VaccineLog.class);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			upcomingVaccines = query.list(); // Get the list of upcoming vaccines
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return upcomingVaccines;
	}

	public VaccineLog getVaccineLogById(int id) {
		Session session = null;
		VaccineLog vaccineLog = null;
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			vaccineLog = session.get(VaccineLog.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return vaccineLog;
	}

	public void updateVaccineLog(VaccineLog vaccineLog) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(vaccineLog);
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
	}

	public void deleteVaccineLog(VaccineLog vaccineLog) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(vaccineLog); // Delete the VaccineLog
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
	}
	
	public List<VaccineLog> getVaccineLogsByChildId(int childId) {
        Session session = null;
        List<VaccineLog> vaccineLogs = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Query<VaccineLog> query = session.createQuery("from VaccineLog where child.id = :childId", VaccineLog.class);
            query.setParameter("childId", childId);
            vaccineLogs = query.list(); // Get the list of vaccine logs for the specified child
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vaccineLogs;
    }
	
    public List<VaccineLog> getUpcomingVaccinesForChild(int childId, Date startDate, Date endDate) {
        Session session = null;
        List<VaccineLog> upcomingVaccines = null;
        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Query<VaccineLog> query = session.createQuery("from VaccineLog where child.id = :childId and date between :startDate and :endDate", VaccineLog.class);
            query.setParameter("childId", childId);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            upcomingVaccines = query.list(); // Get the list of upcoming vaccines for the specified child
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return upcomingVaccines;
    }
}
