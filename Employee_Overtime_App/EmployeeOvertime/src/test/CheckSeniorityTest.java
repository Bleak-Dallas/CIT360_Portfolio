package test;


import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Employee;
import model.EmployeeModel;

public class CheckSeniorityTest {

	EmployeeModel em = new EmployeeModel();
	Employee e = em.findEmployee(1); // get employeeID 1
	List<Integer> seniorityList = em.getEmpoyeeSeniority(); // get all employee's seniority
	int seniority = e.getEmployeeSeniority(); // get employeeId 1 seniority
	boolean result; // store boolean result

	@Before
	public void setUp() throws Exception {
		e = em.findEmployee(1);
		result = em.checkSeniority(seniority); // ** FUNCTION BEING TESTED **
		System.out.println("Current Employee Seniority: " + seniority);
		System.out.println("Employees Seniority: " + seniorityList);
		System.out.println("Assert equal: " + result);

	}

	@Test
	// Will return true if the seniority is contained in any employee seniority
	public void test() {
		Assert.assertTrue(result);
		return;
	}
}
