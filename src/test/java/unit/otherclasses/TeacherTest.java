package unit.otherclasses;

import org.junit.Before;
import org.junit.Test;
import otherclasses.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeacherTest {
    School school;
    Student student;
    ArrayList<String> studentList;
    ArrayList<Course> javaCourseList;
    ArrayList<String> javaCourseNameList;
    ArrayList<String> mySqlCourseNameList;
    StudyProgramme javaStudyProgramme;
    StudyProgramme mySqlStudyProgramme;
    ArrayList<StudyProgramme> studyProgrammeList;
    Teacher teacher;

    @Before
    public void setUp() throws Exception {
        school = new School("name-of-school", "222222-2222", "Pri", "Cipal");
        assertEquals("name-of-school", school.getSchoolName());
        assertEquals("222222-2222", school.getPrincipal().getPersonalNumber().getNumber());
        assertEquals("Pri", school.getPrincipal().getFirstName());
        assertEquals("Cipal", school.getPrincipal().getLastName());
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
        school.setStudyProgrammes(studyProgrammeList);
        teacher = new Teacher(school, "444444-4444", "Tea", "Cher");
        student.setStudyProgramme(javaStudyProgramme);
    }

    @Test
    public void testGradeStudent() throws Exception {
        teacher.gradeStudent("java-basics", "121212-1212", 5L);
        assertEquals(5L, student.calculateAverageGrade(), 0);
    }

    @Test
    public void testGetUngradedStudentsByCourse() throws Exception {
        ArrayList<String> ungradedList = teacher.getUngradedStudentsByCourse("java-basics");
        assertEquals(1, ungradedList.size());
        assertEquals(student.getPersonalNumber().getNumber(), ungradedList.get(0));
    }

    @Test
    public void testSetSchool() throws Exception {
        assertEquals("name-of-school", teacher.getSchool().getSchoolName());
        teacher.setSchool(new School("another-school", "444444-4444", "Rec", "Tor"));
        assertEquals("another-school", teacher.getSchool().getSchoolName());
    }
}