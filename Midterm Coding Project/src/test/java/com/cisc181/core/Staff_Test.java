package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	// ArrayList of Staff

	static ArrayList<Staff> staff1 = new ArrayList<Staff>();

	public static Date newDate(int yr, int mon, int day) {
		Calendar cal2 = Calendar.getInstance();
		cal2.set(yr, mon, day);
		return cal2.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {

		// Add five staff

		staff1.add(new Staff("Bruno", "Taylor", "Hello", newDate(1997, 8, 12), "Daniel Drive", "(123)-324-5335",
				"taylor@aol.com", "T 8:00-10:00am", 1, 54000, newDate(2015, 5, 5), eTitle.MRS));

		staff1.add(new Staff("Mary", "Kay", "Fresh", newDate(1986, 9, 24), "Church Street", "(234)-546-8789",
				"mary@udel.com", "M 1:00-2:00pm", 2, 38000, newDate(2013, 7, 26), eTitle.MRS));

		staff1.add(new Staff("Lauren", "Davis", "Lamp", newDate(1934, 4, 16), "First Street", "(300)-543-4300",
				"ldav@hotmail.com", "F 10:00-12:30pm", 3, 53500, newDate(1978, 13, 14), eTitle.MRS));

		staff1.add(new Staff("James", "Smith", "King", newDate(1987, 4, 19), "Cleve Street", "(215)-290-3489",
				"smith@hotmail.com", "W 9:00-11:00am", 4, 62300, newDate(2014, 4, 12), eTitle.MR));

		staff1.add(new Staff("Ed", "Rone", "Girl", newDate(1944, 3, 29), "Meadow Street", "(302)-636-6436",
				"eddie@hotmail.com", "T 8:15-10:15am", 4, 49300, newDate(2000, 5, 12), eTitle.MR));
	}

	@Test
	public void testStaffSalary() throws PersonException {
		double sum = 0;
		for (Staff avgStaff : staff1) {
			sum += avgStaff.getSalary();
		}
		double average = sum / staff1.size();
		assertEquals(average, 51420, .01);
	}

	@Test(expected = PersonException.class)
	public void testDOBException() throws PersonException {

		new Staff("Ed", "Rone", "Girl", newDate(1900, 2, 9), "Meadow Street", "(302)-636-6436",
				"eddie@hotmail.com", "T 8:15-10:15am", 4, 49300, newDate(2000, 5, 12), eTitle.MR);
	}

	@Test(expected = PersonException.class)
	public void testPhoneNumException() throws PersonException {
		new Staff("Ed", "Rone", "Girl", newDate(1944, 3, 29), "Meadow Street", "302-636-6436",
				"eddie@hotmail.com", "T 8:15-10:15am", 4, 49300, newDate(2000, 5, 12), eTitle.MR);
	}
}