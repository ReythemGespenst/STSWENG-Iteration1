package ph.edu.dlsu.enlistment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    void getDay() {
        // Example test for getDay() method
        Schedule schedule = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        assertEquals(Schedule.Day.MON_THU, schedule.getDay(), "Day should be Mon/Thu");
    }

    @Test
    void getPeriod() {
        // Example test for getPeriod() method
        Schedule schedule = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        assertEquals(Schedule.Period.PERIOD_1, schedule.getPeriod(), "Period should be 8:30am-10am");
    }

    @Test
    void isInConflict() {
        // Example test for isInConflict() method
        Schedule schedule1 = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        Schedule schedule2 = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        Schedule schedule3 = new Schedule(Schedule.Day.TUE_FRI, Schedule.Period.PERIOD_1);

        assertTrue(schedule1.isInConflict(schedule2), "Schedules with the same day and period should be in conflict");
        assertFalse(schedule1.isInConflict(schedule3), "Schedules with different days should not be in conflict");
    }

    @Test
    void testEquals() {
        // Example test for equals() method
        Schedule schedule1 = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        Schedule schedule2 = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        Schedule schedule3 = new Schedule(Schedule.Day.TUE_FRI, Schedule.Period.PERIOD_1);

        assertEquals(schedule1, schedule2, "Schedules with the same day and period should be equal");
        assertNotEquals(schedule1, schedule3, "Schedules with different days should not be equal");
    }

    @Test
    void testHashCode() {
        // Example test for hashCode() method
        Schedule schedule1 = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        Schedule schedule2 = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        Schedule schedule3 = new Schedule(Schedule.Day.TUE_FRI, Schedule.Period.PERIOD_1);

        assertEquals(schedule1.hashCode(), schedule2.hashCode(), "Schedules with the same day and period should have the same hashCode");
        assertNotEquals(schedule1.hashCode(), schedule3.hashCode(), "Schedules with different days should have different hashCodes");
    }

    @Test
    void testToString() {
        // Example test for toString() method
        Schedule schedule = new Schedule(Schedule.Day.MON_THU, Schedule.Period.PERIOD_1);
        assertEquals("Mon/Thu 8:30am-10am", schedule.toString(), "toString() should return formatted day and period");
    }
}