package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	//ArrayLists for each of the different things within the University
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Semester> semesters = new ArrayList<Semester>();
	static ArrayList<Section> sections = new ArrayList<Section>();

	// Enrollment ArraysLists for each of the Students
	static ArrayList<Enrollment> bio1F = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> bio1S = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> crju2F = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> crju2S = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> chem3F = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> chem3S = new ArrayList<Enrollment>();

	// Date for DOB purposes for constructors later on
	public static Date newDate(int yr, int mon, int day) {
		Calendar cal2 = Calendar.getInstance();
		cal2.set(yr, mon, day);
		return cal2.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {

		//New courses
		Course bio = new Course(UUID.randomUUID(), "Cell Biology", 100, eMajor.BUSINESS);
		Course crju = new Course(UUID.randomUUID(), "Hate Crimes", 100, eMajor.CHEM);
		Course chem = new Course(UUID.randomUUID(), "Physical Chemistry", 100, eMajor.PHYSICS);

		// Adds the new courses to the ArrayList
		courses.add(bio);
		courses.add(crju);
		courses.add(chem);

		// Semesters this year
		Semester fall16 = new Semester(UUID.randomUUID(), newDate(2016, 8, 30), newDate(2016, 12, 9));
		Semester spring17 = new Semester(UUID.randomUUID(), newDate(2017, 2, 10), newDate(2017, 5, 26));

		// Adds the semesters to the ArrayList
		semesters.add(spring17);
		semesters.add(fall16);

		// Sections 
		Section fallBio = new Section(bio.getCourseID(), fall16.getSemesterID(), UUID.randomUUID(), 234);
		Section fallCrju = new Section(crju.getCourseID(), fall16.getSemesterID(), UUID.randomUUID(), 213);
		Section fallChem = new Section(chem.getCourseID(), fall16.getSemesterID(), UUID.randomUUID(), 423);

		Section springBio = new Section(bio.getCourseID(), spring17.getSemesterID(), UUID.randomUUID(), 412);
		Section springCrju = new Section(crju.getCourseID(), spring17.getSemesterID(), UUID.randomUUID(), 241);
		Section springChem = new Section(chem.getCourseID(), spring17.getSemesterID(), UUID.randomUUID(), 100);

		// Adds the Sections to the ArrayList
		sections.add(fallBio);
		sections.add(fallCrju);
		sections.add(fallChem);
		sections.add(springBio);
		sections.add(springCrju);
		sections.add(springChem);

		// Creates 10 Student Records
		Student stud1 = new Student("Harry", "Lewison", "Duffy", newDate(1994, 2, 3), eMajor.COMPSI, "10 Lewis Road",
				"(222)-494-4454", "har@yahoo.com", UUID.randomUUID());

		Student stud2 = new Student("Grant", "Ralf", "Nickson", newDate(1995, 2, 9), eMajor.COMPSI,
				"1200 Wall Street", "(343)-332-0504", "sonny@udel.edu", UUID.randomUUID());

		Student stud3 = new Student("Frank", "Will", "Perse", newDate(1994, 11, 9), eMajor.CHEM,
				"983 Red Road", "(903)-225-8989", "willi@udel.edu", UUID.randomUUID());

		Student stud4 = new Student("Tay", "Christina", "Rockefella", newDate(1994, 5, 5), eMajor.NURSING, "15 Reten Street",
				"(215)-125-6542", "tcr@udel.edu", UUID.randomUUID());

		Student stud5 = new Student("Tims", "San", "Mald", newDate(1997, 12, 7), eMajor.PHYSICS,
				"787 Daniel Road", "(302)-234-0964", "san@aol.com", UUID.randomUUID());

		Student stud6 = new Student("Brandon", "Flugger", "Brown", newDate(1996, 7, 31), eMajor.NURSING,
				"10 Blue Lane", "(355)-656-4054", "jugger@udel.edu", UUID.randomUUID());

		Student stud7 = new Student("Max", "Wade", "Tones", newDate(1998, 4, 30), eMajor.PHYSICS, "!3 Times Square",
				"(484)-885-2330", "maxie@yahoo.com", UUID.randomUUID());

		Student stud8 = new Student("Mark", "Red", "Laws", newDate(1995, 9, 8), eMajor.BUSINESS, "490 Brr Court",
				"(505)-252-6445", "ren@aol.com", UUID.randomUUID());

		Student stud9 = new Student("KJ", "Brett", "Jack", newDate(1995, 3, 31), eMajor.COMPSI,
				"78 Shiver Court", "(398)-226-4039", "jakce@udel.edu", UUID.randomUUID());

		Student stud10 = new Student("Nicole", "Ricky", "Collins", newDate(1994, 11, 28), eMajor.CHEM, "79 New Lane",
				"(484)-103-4405", "nikki@verizon.net", UUID.randomUUID());

		// Adds the Students to the ArrayList
		students.add(stud1);
		students.add(stud2);
		students.add(stud3);
		students.add(stud4);
		students.add(stud5);
		students.add(stud6);
		students.add(stud7);
		students.add(stud8);
		students.add(stud9);
		students.add(stud10);

		// List of each of the possible grades for the students in the semesters
		ArrayList<Integer> gradeSet1 = new ArrayList<Integer>(Arrays.asList(95, 71, 32, 97, 79, 92, 67, 63, 85, 73));
		ArrayList<Integer> gradeSet2 = new ArrayList<Integer>(Arrays.asList(95, 76, 43, 97, 60, 78, 85, 67, 83, 83));
		ArrayList<Integer> gradeSet3 = new ArrayList<Integer>(Arrays.asList(96, 75, 65, 87, 74, 97, 73, 69, 80, 36));

		// Enrolls every student into course sections
		for (int k = 0; k < students.size(); k++) {

			bio1F.add(new Enrollment(sections.get(0).getSectionID(), students.get(k).getStudentID()));
			bio1F.get(k).setGrade(gradeSet1.get(k));

			bio1S.add(new Enrollment(sections.get(1).getSectionID(), students.get(k).getStudentID()));
			bio1S.get(k).setGrade(gradeSet2.get(k));

			crju2F.add(new Enrollment(sections.get(2).getSectionID(), students.get(k).getStudentID()));
			crju2F.get(k).setGrade(gradeSet3.get(k));

			crju2S.add(new Enrollment(sections.get(3).getSectionID(), students.get(k).getStudentID()));
			crju2S.get(k).setGrade(gradeSet1.get(k));

			chem3F.add(new Enrollment(sections.get(4).getSectionID(), students.get(k).getStudentID()));
			chem3F.get(k).setGrade(gradeSet2.get(k));

			chem3S.add(new Enrollment(sections.get(5).getSectionID(), students.get(k).getStudentID()));
			chem3S.get(k).setGrade(gradeSet3.get(k));
		}

	}

	// Calculates each student's gpa
	public double calcStudentGPA(ArrayList<Enrollment> bio1F, ArrayList<Enrollment> bio1S, ArrayList<Enrollment> crju2F,
			ArrayList<Enrollment> crju2S, ArrayList<Enrollment> chem3F, ArrayList<Enrollment> chem3S, int Student) {
		
		//Constant declared for the number of courses
		final int COURSENUM = 6;
		
		double GPAAVG = 0;

		if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 95) {
			GPAAVG = 4.0;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 90) {
			GPAAVG = 3.75;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 85) {
			GPAAVG = 3.50;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 80) {
			GPAAVG = 3.00;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 75) {
			GPAAVG = 2.50;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 70) {
			GPAAVG = 2.00;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 65) {
			GPAAVG = 1.50;
		} else if ((bio1F.get(Student).getGrade() + bio1S.get(Student).getGrade() + crju2F.get(Student).getGrade()
				+ crju2S.get(Student).getGrade() + chem3F.get(Student).getGrade() + chem3S.get(Student).getGrade())
				/ COURSENUM >= 60) {
			GPAAVG = 1.00;
		} else {
			GPAAVG = 0.00;
		}
		return GPAAVG;
	}

	// Tests for the Student GPA's within all of the courses that they are taking
	@Test
	public void StudentGPATest() {
		assertEquals(4.0, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 0), .001);
		assertEquals(2.0, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 1), .001);
		assertEquals(0.0, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 2), .001);
		assertEquals(3.75, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 3), .001);
		assertEquals(2.0, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 4), .001);
		assertEquals(3.5, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 5), .001);
		assertEquals(2.5, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 6), .001);
		assertEquals(1.5, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 7), .001);
		assertEquals(3.0, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 8), .001);
		assertEquals(1.0, calcStudentGPA(bio1F, bio1S, crju2F, crju2S, chem3F, chem3S, 9), .001);
	}

	// Calulates course avg
	public static double CourseGr(ArrayList<Enrollment> courses) {

		double avg = 0;
		double courseAvg = 0;

		for (int y = 0; y < students.size(); y++) {
			avg += courses.get(y).getGrade();
			courseAvg = (avg / students.size());
		}
		return courseAvg;
	}

	// Tests for the course average
	@Test
	public void testCourseGr() {
		assertEquals(75.4, CourseGr(bio1F), .01);
		assertEquals(76.7, CourseGr(bio1S), 01);
		assertEquals(75.2, CourseGr(crju2F), .01);
		assertEquals(75.4, CourseGr(crju2S), .01);
		assertEquals(76.7, CourseGr(chem3F), 01);
		assertEquals(75.2, CourseGr(chem3S), .01);
	}

	// changing major
	public static void ChangeOfMajor(eMajor maj, Student stu) {
		stu.seteMajor(maj);
	}

	// Test for the changed major
	@Test
	public void testMajorChangeStudent() {
		ChangeOfMajor(eMajor.CHEM, students.get(5));
		assertEquals(eMajor.CHEM, students.get(5).geteMajor());
	}

}