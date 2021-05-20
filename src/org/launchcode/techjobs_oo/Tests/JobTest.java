package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.launchcode.techjobs_oo.*;

public class JobTest {

    Job test;

    @Before
    public void createJobObject() {
        test = new Job(
                "Product Tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
    }

    @Test
    public void testSettingJobId() {
        Job empty1 = new Job();
        Job empty2 = new Job();
        assertEquals(1, empty2.getId() - empty1.getId(), 0);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        // test type of each field
        assertTrue(test.getName() instanceof String);
        assertTrue(test.getEmployer() instanceof Employer);
        assertTrue(test.getLocation() instanceof Location);
        assertTrue(test.getPositionType() instanceof PositionType);
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);

        // test value of each field
        assertEquals("Product Tester", test.getName());
        assertEquals("ACME", test.getEmployer().getValue());
        assertEquals("Desert", test.getLocation().getValue());
        assertEquals("Quality control", test.getPositionType().getValue());
        assertEquals("Persistence", test.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() { // weird name for something testing inequality
        Job notTest = new Job(
                "Product Tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        assertFalse(test.equals(notTest));
    }

    @Test
    public void toStringBeginsAndEndsWithNewLine() {
        assertEquals('\n', test.toString().charAt(0));
        assertEquals('\n', test.toString().charAt(test.toString().length() - 1));
    }

    @Test
    public void toStringFormatsJobToSpec() { // why does this test take so long?
        String expected = "\n" +
                "ID: " + test.getId() + "\n" +
                "Name: Product Tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";
        assertEquals(expected, test.toString());
    }

    @Test
    public void toStringDisplaysMessageForEmptyFields() {
        Job emptyFields = new Job(
                "Placeholder",
                new Employer(null),
                null,
                new PositionType(""),
                new CoreCompetency(null)
        );

        String expected = "\n" +
                "ID: " + emptyFields.getId() + "\n" +
                "Name: Placeholder\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n";

        assertEquals(expected, emptyFields.toString());
    }

    @Test
    public void toStringDisplaysMessageForEmptyJob() {
        Job empty = new Job();
        String expected = "\nOOPS! This job does not seem to exist.\n";
        assertEquals(expected, empty.toString());
    }
}
