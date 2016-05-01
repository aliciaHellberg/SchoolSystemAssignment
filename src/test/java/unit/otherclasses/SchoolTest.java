package unit.otherclasses;

import org.junit.Before;
import org.junit.Test;
import otherclasses.*;
import paymentapp.PaymentApp;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.*;


public class SchoolTest {
    School school;
    ArrayList<String> studentList;
    ArrayList<Course> javaCourseList;
    ArrayList<String> javaCourseNameList;
    ArrayList<String> mySqlCourseNameList;
    ArrayList<StudyProgramme> studyProgrammeList;
    ArrayList<Teacher> teacherList;

    @Before
    public void setup() {
        school = new School("name-of-school", "222222-2222", "Principal", "Principale");
        assertEquals("name-of-school", school.getSchoolName());
        assertEquals("222222-2222", school.getPrincipal().getPersonalNumber().getNumber());
        assertEquals("Principal", school.getPrincipal().getFirstName());
        assertEquals("Principale", school.getPrincipal().getLastName());
        studentList = new ArrayList<>();
        studentList.add("242424-2424");
        studentList.add("464646-4646");
        javaCourseList = new ArrayList<>();
        javaCourseList.add(new Course("java-basics", 3));
        javaCourseList.add(new Course("for-loops", 3));
        javaCourseList.add(new Course("extended-for-loops", 4));
        javaCourseNameList = new ArrayList<>();
        javaCourseNameList.add("java-basics");
        javaCourseNameList.add("for-loops");
        javaCourseNameList.add("extended-for-loops");
        mySqlCourseNameList = new ArrayList<>();
        mySqlCourseNameList.add("create database");
        mySqlCourseNameList.add("crud handling");
        mySqlCourseNameList.add("advanced joins");
        studyProgrammeList = new ArrayList<>();
        studyProgrammeList.add(new StudyProgramme(school, "java-programme", javaCourseNameList, 10, 30, studentList));
        studyProgrammeList.add(new StudyProgramme(school, "mysql-programme", mySqlCourseNameList, 5, 20, studentList));
        teacherList = new ArrayList<>();
        teacherList.add(new Teacher(school, "141414-1414", "java", "expert"));
        teacherList.add(new Teacher(school, "161616-1616", "data", "base"));
    }

    @Test
    public void testSetSchoolName() throws Exception {
        school.setSchoolName("new-name-of-school");
        assertEquals("new-name-of-school", school.getSchoolName());
    }

    @Test
    public void testSetPrincipal() throws Exception {
        Principal principal = new Principal(school, "121212-1212", "Pri", "Prince");
        school.setPrincipal(principal);
        assertEquals("121212-1212", school.getPrincipal().getPersonalNumber().getNumber());
        assertEquals("Pri", school.getPrincipal().getFirstName());
        assertEquals("Prince", school.getPrincipal().getLastName());
    }

    @Test
    public void testSetStudyProgrammes() throws Exception {
        school.setStudyProgrammes(studyProgrammeList);
        assertEquals(2, school.getStudyProgrammes().size());
    }

    @Test
    public void testSetTeachers() throws Exception {
        school.setTeachers(teacherList);
        assertEquals(2, school.getTeachers().size());
    }

    @Test
    public void testSetCourses() throws Exception {
        school.setCourses(javaCourseList);
        assertEquals(3, school.getCourses().size());
    }

    @Test
    public void testSetStudents() throws Exception {
        Hashtable studentTable = new Hashtable();
        studentTable.put("181818-1818", new Student(school, "181818-1818", "Kristina", "Kristensson"));
        school.setStudents(studentTable);
        assertEquals("Kristina", school.getStudents().get("181818-1818").getFirstName());
        assertEquals("Kristensson", school.getStudentByPersonalNumber("181818-1818").getLastName());
    }

    @Test
    public void testSetStudyFees() throws Exception {
        ArrayList<StudyFee> studyFeeList = new ArrayList<>();
        studyFeeList.add(new StudyFee(2016, 23000F));
        school.setStudyFees(studyFeeList);
        assertEquals(23000F, school.getStudyFees().get(0).getAmount(), 0);
    }

    @Test
    public void testSetPaymentApp() throws Exception {
        PaymentApp paymentApp = new PaymentApp();
        school.setPaymentApp(paymentApp);
        assertEquals(paymentApp, school.getPaymentApp());
    }
}