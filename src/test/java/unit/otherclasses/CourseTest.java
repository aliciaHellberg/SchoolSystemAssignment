package unit.otherclasses;

import org.junit.Test;
import otherclasses.Course;
import otherclasses.Principal;
import otherclasses.School;
import otherclasses.Teacher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CourseTest {
    School school = new School("school-name", "222222-2222", "Principal", "Principale");
    Teacher javaTeacher = new Teacher(school, "121212-1212", "Java", "Teacher");
    Teacher mySqlTeacher = new Teacher(school, "444444-4444", "MySql", "Teacher");

    @Test
    public void testSetName() throws Exception {
        Course course = new Course("name-of-course", 10);
        assertEquals("name-of-course", course.getName());
        course.setName("new-name-of-course");
        assertEquals("new-name-of-course", course.getName());
    }

    @Test
    public void testSetPoints() throws Exception {
        Course course = new Course("name-of-course", 10);
        assertEquals(10, course.getPoints());
        course.setPoints(12);
        assertEquals(12, course.getPoints());
    }

    @Test
    public void testSetTeachers() throws Exception {
        Course course = new Course("name-of-course", 10);
        assertEquals(0, course.getTeachers().size());
        course.addTeacher("222222-2222");
        course.addTeacher("333333-3333");
        assertEquals(2, course.getTeachers().size());
        course.removeTeacher("333333-3333");
        assertEquals(1, course.getTeachers().size());
        ArrayList<String> teacherList = new ArrayList<>();
        teacherList.add(javaTeacher.getPersonalNumber().getNumber());
        teacherList.add(mySqlTeacher.getPersonalNumber().getNumber());
        course.setTeachers(teacherList);
        assertEquals(2, course.getTeachers().size());
    }
}