/**
 * 
 */
package test;

import java.sql.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Employee;
import model.EmployeeModel;


public class EmployeeDataTestFail {
	Employee e = new Employee();
	EmployeeModel em = new EmployeeModel();
	Date date;

	@Before
	public void setUp() throws Exception {
		e = em.findEmployee(1); // ** FUNCTION BEING TESTED **
		date = (Date) e.getEmployeeHireDate();
	}

	

	@Test
	public void test() {
		Assert.assertEquals("Joe Smith", e.getEmployeeName());
		Assert.assertEquals(date, e.getEmployeeHireDate());
		Assert.assertEquals(1, e.getEmployeeSeniority());  // this will fail because it is suppose to be 3
		return;
	}

}