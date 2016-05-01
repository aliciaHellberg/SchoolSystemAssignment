package unit.otherclasses;

import org.junit.Before;
import org.junit.Test;
import otherclasses.StudyFee;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudyFeeTest {
    ArrayList<String> studentList;
    StudyFee studyFee;

    @Before
    public void setup() {
        studentList = new ArrayList<>();
        studentList.add("222222-2222");
        studentList.add("121212-1212");
        studentList.add("444444-4444");
        assertEquals(3, studentList.size());
        studyFee = new StudyFee(2016, 23000F);
        assertEquals(2016, studyFee.getYear());
        assertEquals(23000F, studyFee.getAmount(), 0);
    }

    @Test
    public void testSetYear() throws Exception {
        studyFee.setYear(2017);
        assertEquals(2017, studyFee.getYear());
    }

    @Test
    public void testSetAmount() throws Exception {
        studyFee.setAmount(24000F);
        assertEquals(24000F, studyFee.getAmount(), 0);
    }

    @Test
    public void testSetStudentsWhoHavePaid() throws Exception {
        studyFee.setStudentsWhoHavePaid(studentList);
        assertEquals(3, studyFee.getStudentsWhoHavePaid().size());
        studyFee.addStudentWhoHasPaid("888888-8888");
        assertEquals(4, studyFee.getStudentsWhoHavePaid().size());
    }

}