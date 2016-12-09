package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Activity;
import entities.Employee;

public class EmployeeActivityModel {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	
	public List<Employee> getAllEmployeesWithActivities() {
        //create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Query query = session.createQuery("from EmployeeActivity order by activityDate");
        List<Employee> employees = (List<Employee>)query.list();
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return employees;
        
        }
	
	public void deleteActivity(Activity deleteActivity) {
		//create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.delete(deleteActivity);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
		
	}
	
	public Activity findActivity(String name) {
		//create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Activity am = (Activity) session.get(Activity.class, name);
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return am;
	}
	
	public List<Activity> getAllActivity() {
        //create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Query query = session.createQuery("from Activity order by activityDate");
        List<Activity> activities = (List<Activity>)query.list();
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return activities;
        
	}

}
