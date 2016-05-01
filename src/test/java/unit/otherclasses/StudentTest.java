package unit.otherclasses;

import org.junit.Before;
import org.junit.Test;
import otherclasses.*;
import paymentapp.CreditCard;
import paymentapp.CreditCardType;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    Student student;
    School school;
    ArrayList<String> studentList;
    ArrayList<Course> javaCourseList;
    ArrayList<String> javaCourseNameList;
    ArrayList<String> mySqlCourseNameList;
    StudyProgramme javaStudyProgramme;
    StudyProgramme mySqlStudyProgramme;
    ArrayList<StudyProgramme> studyProgrammeList;
    ArrayList<Teacher> teacherList;
    CreditCard masterCard = new CreditCard("Lisa", CreditCardType.MasterCard, "1212121212121212", LocalDateTime.now().plusDays(2L), "123");

    @Before
    public void setup() {
        school = new School("name-of-school", "222222-2222", "Principal", "Principale");
        assertEquals("name-of-school", school.getSchoolName());
        assertEquals("222222-2222", school.getPrincipal().getPersonalNumber().getNumber());
        assertEquals("Principal", school.getPrincipal().getFirstName());
        assertEquals("Principale", school.getPrincipal().getLastName());
        student = new Student(school, "121212-1212", "Stu", "Dent");
        studentList = new ArrayList<>();
        studentList.add(student.getPersonalNumber().getNumber());
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
        javaStudyProgramme = new StudyProgramme(school, "java-programme", javaCourseNameList, 10, 30, studentList);
        mySqlStudyProgramme = new StudyProgramme(school, "mysql-programme", mySqlCourseNameList, 5, 20, studentList);
        studyProgrammeList = new ArrayList<>();
        studyProgrammeList.add(javaStudyProgramme);
        studyProgrammeList.add(mySqlStudyProgramme);
        teacherList = new ArrayList<>();
        teacherList.add(new Teacher(school, "141414-1414", "java", "expert"));
        teacherList.add(new Teacher(school, "161616-1616", "data", "base"));
        school.setStudyProgrammes(studyProgrammeList);
        school.setCourses(javaCourseList);
        student.signUpForStudyProgramme("java-programme");
        ArrayList<Exam> examList = new ArrayList<>();
        examList.add(new Exam("java-basics", 5F));
        examList.add(new Exam("for-loops", 4F));
        student.setTakenExams(examList);
    }

    @Test
    public void testSignUpForStudyProgramme() throws Exception {
        student.signUpForStudyProgramme("java-programme");
        assertEquals("java-programme", student.getStudyProgramme().getName());
    }

    @Test
    public void testCalculateAverageGrade() throws Exception {
        assertEquals(4.5F, student.calculateAverageGrade(), 0);
    }

    @Test
    public void testHasClearedTheProgramme() throws Exception {
        assertFalse(student.hasClearedTheProgramme());
    }

    @Test
    public void testPayStudyFee() throws Exception {
        ArrayList<StudyFee> studyFeeList = new ArrayList<>();
        studyFeeList.add(new StudyFee(2016, 23000F));
        school.setStudyFees(studyFeeList);
        assertEquals(200, student.payStudyFee(2016, masterCard).getId());
    }

    @Test
    public void testGetReachedNumberOfStudyPoints() throws Exception {
        assertEquals(6, student.getReachedNumberOfStudyPoints());
    }

    @Test
    public void testListAllCourses() throws Exception {
        assertEquals(3, student.listAllCourses().size());
    }

    @Test
    public void testToString() throws Exception {
        try {
            student.toString();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSetSchool() throws Exception {
        assertEquals("name-of-school", student.getSchool().getSchoolName());
        student.setSchool(new School("another-school", "444444-4444", "Rec", "Tor"));
        assertEquals("another-school", student.getSchool().getSchoolName());
    }

    @Test
    public void testSetTakenExams() throws Exception {
        assertEquals(2, student.getTakenExams().size());
        ArrayList<Exam> examList = new ArrayList<>();
        examList.add(new Exam("java-basics", 5F));
        examList.add(new Exam("for-loops", 4F));
        examList.add(new Exam("extended-loops", 5F));
        student.setTakenExams(examList);
        assertEquals(3, student.getTakenExams().size());
        assertEquals("extended-loops", student.getTakenExams().get(2).getCourseName());
    }

    @Test
    public void testSetStudyProgramme() throws Exception {
        assertEquals("java-programme", student.getStudyProgramme().getName());
        student.setStudyProgramme(mySqlStudyProgramme);
        assertEquals("mysql-programme", student.getStudyProgramme().getName());
    }
}
