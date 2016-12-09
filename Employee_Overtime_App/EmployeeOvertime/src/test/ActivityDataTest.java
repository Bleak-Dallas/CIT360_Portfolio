package test;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Activity;
import model.ActivityModel;

public class ActivityDataTest {
	Activity a = new Activity();
	ActivityModel am = new ActivityModel();
	Date date;

	@Before
	public void setUp() throws Exception {
		a = am.findActivity(1); // ** FUNCTION BEING TESTED **
		date = (Date) a.getActivityDate();
	}

	

	@Test
	public void test() {
		// ** Testing to see if we are getting information from the database
		Assert.assertEquals("December 10 Saturday Clinic", a.getActivityName());
		Assert.assertEquals(date, a.getActivityDate());
		return;
	}
	
}

