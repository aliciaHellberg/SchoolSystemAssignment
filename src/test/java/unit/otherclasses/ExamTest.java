package unit.otherclasses;

import org.junit.Test;
import otherclasses.Exam;

import static org.junit.Assert.*;


public class ExamTest {

    @Test
    public void testSetCourseName() throws Exception {
        Exam exam = new Exam("name-of-course", 5F);
        assertEquals("name-of-course", exam.getCourseName());
        exam.setCourseName("new-name-of-course");
        assertEquals("new-name-of-course", exam.getCourseName());
    }

    @Test
    public void testSetGrade() throws Exception {
        Exam exam = new Exam("name-of-course", 5F);
        assertEquals(5F, exam.getGrade(), 0);
        exam.setGrade(4F);
        assertEquals(4F, exam.getGrade(), 0);
    }
}