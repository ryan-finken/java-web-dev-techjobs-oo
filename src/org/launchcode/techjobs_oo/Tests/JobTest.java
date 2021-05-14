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
    public void createJobObjects() {
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
}
