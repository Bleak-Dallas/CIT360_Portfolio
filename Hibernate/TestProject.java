package testproject;

import model.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestProject {

    public static void main(String[] args) {
        //create new emlpoyee object
        EmployeeDetails employee = new EmployeeDetails();
        //set values for a new employee
        employee.setEmployeeId(2);
        employee.setEmployeeName("Brandon");
        employee.setEmployeeSeniority(2);
        

        //create a session factory in hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the employee object to the test database
        session.save(employee);
        //commit the transaction to the databse
        session.getTransaction().commit();

    }
    
}
