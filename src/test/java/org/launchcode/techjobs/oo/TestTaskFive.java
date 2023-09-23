package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.lineSeparator;


/**
 * Created by LaunchCode
 */
public class TestTaskFive extends AbstractTest {

    @Mocked Job job;

    @Test
    public void testTestToStringStartsAndEndsWithNewLineExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringStartsAndEndsWithNewLineMethod = null;

        try {
            testToStringStartsAndEndsWithNewLineMethod = jobTestClass.getMethod("testToStringStartsAndEndsWithNewLine");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringStartsAndEndsWithNewLine method");
        }
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String newLine = lineSeparator();
        Job job = new Job("New Job", new Employer("asdf"), new Location("sadf"), new PositionType("asdf"), new CoreCompetency("asdf"));
//        System.out.println(String.valueOf(job.toString().charAt(job.toString().length()-1))); //printing extra line
        assertEquals(newLine, String.valueOf(job.toString().charAt(0)));
        assertEquals(newLine, String.valueOf(job.toString().charAt(job.toString().length()-1)));
    }

    @Test
    public void testTestToStringContainsCorrectLabelsAndDataExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringContainsCorrectLabelsAndDataMethod = null;

        try {
            testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringContainsCorrectLabelsAndData method");
        }
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String newLine = lineSeparator();
        Job job = createJob("Web Developer", "LaunchCode", "StL", "Back-end developer", "Java");
        assertEquals(newLine + "ID: " + job.getId() + newLine +
                "Name: " + "Web Developer" + newLine +
                "Employer: " + "LaunchCode" + newLine +
                "Location: " + "StL" + newLine +
                "Position Type: " + "Back-end developer" + newLine +
                "Core Competency: " + "Java" + newLine, job.toString());
    }

    @Test
    public void testTestToStringHandlesEmptyFieldExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringHandlesEmptyField = null;

        try {
            testToStringHandlesEmptyField = jobTestClass.getMethod("testToStringHandlesEmptyField");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringHandlesEmptyField method");
        }
    }

    @Test
    public void testToStringHandlesEmptyField() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String newLine = lineSeparator();
        Job job = createJob("Web Developer", "", "StL", "", "Java");
        assertEquals(newLine + "ID: " + job.getId() + newLine +
                "Name: " + "Web Developer" + newLine +
                "Employer: " + "Data not available" + newLine +
                "Location: " + "StL" + newLine +
                "Position Type: " + "Data not available" + newLine +
                "Core Competency: " + "Java" + newLine, job.toString());
    }

}
