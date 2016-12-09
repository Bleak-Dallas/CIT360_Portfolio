package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Activity;
import entities.Employee;

public class EmployeeModel {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void addEmployee(Employee newEmployee) {
        //create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.save(newEmployee);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close(); 
    }
	
	public List<Employee> getAllEmployees() {
        //create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Query query = session.createQuery("from Employee order by employeeSeniority");
        List<Employee> employees = (List<Employee>)query.list();
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return employees;
        
        }
	
	public List<Integer> getEmpoyeeSeniority() {
        //create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Query query = session.createQuery("select employeeSeniority from Employee");
        List<Integer> seniority = (List<Integer>)query.list();
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return seniority;
        
        }
	
	public boolean checkSeniority(int seniority) {
		List<Integer> em = getEmpoyeeSeniority();
		return em.contains(seniority);
	}
	
	public Employee findEmployee(Integer id) {
		//create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Employee em = (Employee) session.get(Employee.class, id);
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return em;
	}

	public void deleteEmployee(Employee deleteEmployee) {
		//create a session and open a session in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.delete(deleteEmployee);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
		
	}
	
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
	
}
