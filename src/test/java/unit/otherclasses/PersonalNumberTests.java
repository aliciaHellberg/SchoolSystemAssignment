package unit.otherclasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import otherclasses.School;
import otherclasses.Student;

public class PersonalNumberTests {
	private static School school = new School("Nacka","770302-7131","J","S");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		Student student = new Student(school,"770302-7131","","");
		assertTrue("Unexpexted gender", student.isMale());
		assertEquals(39,student.getAge());
	}
	@Test
	public void test2() {
		Student student = new Student(school,"770302-7123","","");
		assertTrue("Unexpexted gender", student.isFemale());
	}
	/*
	@Test
	public void test3() {
		Student student = new Student(school,"770302-7122","","");
		
	}
	*/
	@Test
	public void test4() {
		Student student = new Student(school,"180229-7133","","");
		assertTrue("Unexpexted gender", student.isMale());
	}
	
	@Test
	public void test5() {
		Student student = new Student(school,"180330-7139","","");
		assertTrue("Unexpexted gender", student.isMale());
	}
	
	@Test
	public void test6() {
		Student student = new Student(school,"160520","","");
		
	}
	/*
	@Test
	public void test7() {
		Student student = new Student(school,"051620","","");
		
	}
	@Test
	public void test8() {
		Student student = new Student(school,"770362","","");
		
	}
	@Test
	public void test9() {
		Student student = new Student(school,"770360","","");
		
	}
	*/

}
