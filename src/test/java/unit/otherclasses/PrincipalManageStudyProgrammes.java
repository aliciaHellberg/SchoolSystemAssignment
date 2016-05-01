package unit.otherclasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import otherclasses.*;

public class PrincipalManageStudyProgrammes {
	Principal principal;
	static School school;
	@Before
	public void setUpBeforeClass() throws Exception {
		school = new School("Solnademin", "770301-1119","John","Smith");
	}

	@Test
	public void testCreateProgram() {
		Principal principal = school.getPrincipal();
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		assertEquals("Unexpected number of study programmes",1, school.getStudyProgrammes().size());
	}
	
	@Test
	public void testRemoveProgram() {
		Principal principal = school.getPrincipal();
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		
		assertEquals("Unexpected number of study programmes",1, school.getStudyProgrammes().size());
		
		principal.removeStudyProgramme("Test15");
		
		assertEquals("Unexpected number of study programmes",0, school.getStudyProgrammes().size());
	}
	
	@Test
	public void testAddCourseToProgram() {
		Principal principal = school.getPrincipal();
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		
		Course programmering = new Course("Programmering",50);
		principal.addCourseToSchool(programmering);
		principal.addCourseToStudyProgramme(programme.getName(), programmering.getName());
		
		assertEquals("Unexpected number of courses to this studyprogram: " + programme.getName(),1, programme.getCourseNames().size());
		assertEquals("Unexpected course in programme" + programme.getName(),programmering.getName(), programme.getCourseNames().get(0));

	}
	@Test
	public void testRemoveCourseFromProgram() {
		Principal principal = school.getPrincipal();
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		
		Course programmering = new Course("Programmering",50);
		principal.addCourseToSchool(programmering);
		principal.addCourseToStudyProgramme(programme.getName(), programmering.getName());
		
		assertEquals("Unexpected number of courses to this studyprogram: " + programme.getName(),1, programme.getCourseNames().size());
		
		principal.removeCourseFromStudyProgramme(programme.getName(), programmering.getName());
		
		assertEquals("Unexpected number of courses to this studyprogram: ",0, programme.getCourseNames().size());
	}
	@Test
	public void testAddCourseToSchool() {
		Principal principal = school.getPrincipal();
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		
		Course programmering = new Course("Programmering",50);
		principal.addCourseToSchool(programmering);
		Course math = new Course("Math",20);
		principal.addCourseToSchool(math);
		
		assertEquals("You only have: " +school.getCourses().size()+ " in your course list",2,school.getCourses().size());
	}
	@Test
	public void testRemoveCourseFromSchool() {
		Principal principal = school.getPrincipal();
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		
		Course programmering = new Course("Programmering",50);
		principal.addCourseToSchool(programmering);
		Course math = new Course("Math",20);
		principal.addCourseToSchool(math);
		principal.removeCourseFromSchool(math.getName());
		
		assertEquals("You only have: " +school.getCourses().size()+ " in your course list",1,school.getCourses().size());
		}
	@Test
	public void testAddTeacherToSchool() {
		Principal principal = school.getPrincipal();
		Teacher fredrik = new Teacher(school,"770301-1119","Fredrik","Smith" );
		principal.addTeacherToSchool(fredrik);
		
		assertEquals(1, school.getTeachers().size());
	}
	@Test
	public void testAddStudent() {
		Student fredrik = new Student(school, "770301-1119", "Fredrik", "Smith");
		school.addStudent(fredrik);
		Student kalle = new Student(school, "940411-0422", "Kalle", "Anka");
		school.addStudent(kalle);

		assertEquals(2, school.getStudents().size());
		
	}
	@Test
	public void testRemoveStudent() {
		Student fredrik = new Student(school, "770301-1119", "Fredrik", "Smith");
		school.addStudent(fredrik);
		Student kalle = new Student(school, "940411-0422", "Kalle", "Anka");
		school.addStudent(kalle);
		school.removeStudent(fredrik.getPersonalNumber().getNumber());
		assertEquals(1, school.getStudents().size());
	}
	@Test
	public void testAssignTeacher() {
		Principal principal = school.getPrincipal();
		Teacher fredrik = new Teacher(school,"770301-1119","Fredrik","Smith" );
		principal.addTeacherToSchool(fredrik);
		Teacher anka = new Teacher(school,"940411-0422","Kalle","Anka" );
		principal.addTeacherToSchool(anka);
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		Course programmering = new Course("programmering", 50);
		principal.addCourseToSchool(programmering);
		principal.addCourseToStudyProgramme(programme.getName(), programmering.getName());
		principal.assignTeacherToCourse(fredrik.getPersonalNumber().getNumber(), programmering.getName());
		principal.assignTeacherToCourse(anka.getPersonalNumber().getNumber(), programmering.getName());
		assertEquals(2, programmering.getTeachers().size());
	}
	@Test
	public void testUnAssignTeacher() {
		Principal principal = school.getPrincipal();
		Teacher fredrik = new Teacher(school,"770301-1119","Fredrik","Smith" );
		principal.addTeacherToSchool(fredrik);
		Teacher anka = new Teacher(school,"940411-0422","Kalle","Anka" );
		principal.addTeacherToSchool(anka);
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		Course programmering = new Course("programmering", 50);
		principal.addCourseToSchool(programmering);
		principal.addCourseToStudyProgramme(programme.getName(), programmering.getName());
		principal.assignTeacherToCourse(fredrik.getPersonalNumber().getNumber(), programmering.getName());
		principal.assignTeacherToCourse(anka.getPersonalNumber().getNumber(), programmering.getName());
		principal.unassignTeacherFromCourse(fredrik.getPersonalNumber().getNumber(), programmering.getName());
		
		assertEquals(1, programmering.getTeachers().size());
	}
	/*
	@Test
	public void testApplyStudyFees() {
		Principal principal = school.getPrincipal();
		principal.applyStudyFees();
	}
	*/
	@Test
	public void testStudentsWhoHaveNotPaid() {
		Principal principal = school.getPrincipal();
		Teacher fredrik = new Teacher(school,"770301-1119","Fredrik","Smith" );
		principal.addTeacherToSchool(fredrik);
		Teacher anka = new Teacher(school,"940411-0422","Kalle","Anka" );
		principal.addTeacherToSchool(anka);
		StudyProgramme programme = new StudyProgramme(school, "Test15", null, 160, 30, null);
		principal.addStudyProgramme(programme);
		Course programmering = new Course("programmering", 50);
		principal.addCourseToSchool(programmering);
		principal.addCourseToStudyProgramme(programme.getName(), programmering.getName());
		principal.assignTeacherToCourse(fredrik.getPersonalNumber().getNumber(), programmering.getName());
		principal.assignTeacherToCourse(anka.getPersonalNumber().getNumber(), programmering.getName());
		principal.unassignTeacherFromCourse(fredrik.getPersonalNumber().getNumber(), programmering.getName());
		
		assertEquals(1, programmering.getTeachers().size());
	}
	
}
