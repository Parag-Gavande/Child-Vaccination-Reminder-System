package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.configuration.HibernateConfiguration;
import com.entity.Child;

public class ChildDAO {

	public void addChild(Child child) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(child);
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

	public List<Child> getAllChildren() {
		Session session = null;
		Transaction transaction = null;
		List<Child> children = null;

		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Query<Child> query = session.createQuery("from Child", Child.class);
			children = query.list();

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

		return children;
	}

	public Child getChildById(int childId) {
		Session session = null;
		Child child = null;
		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			child = session.get(Child.class, childId); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return child;
	}

	public void updateChild(Child child) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(child); 
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

	public void deleteChild(int childId) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateConfiguration.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			// Retrieve the child entity by ID
			Child child = session.get(Child.class, childId);
			if (child != null) {
				session.delete(child); // Delete the child entity
			}

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

	
	public void childPasswordChange(Child child) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(child); // Update the existing Child entity
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

}
