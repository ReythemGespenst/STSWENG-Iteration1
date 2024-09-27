package ph.edu.dlsu.enlistment;

import java.util.Objects;
public class Schedule {

    // Days provided
    public enum Day {
        MON_THU("Mon/Thu"),
        TUE_FRI("Tue/Fri"),
        WED_SAT("Wed/Sat");

        private final String label;

        Day(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    //for the periods listed
    public enum Period {
        PERIOD_1("8:30am-10am"),
        PERIOD_2("10am-11:30am"),
        PERIOD_3("11:30am-1pm"),
        PERIOD_4("1pm-2:30pm"),
        PERIOD_5("2:30pm-4pm"),
        PERIOD_6("4pm-5:30pm");

        private final String label;

        Period(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Day day;
    private Period period;

    // construc
    public Schedule(Day day, Period period) {
        this.day = day;
        this.period = period;
    }

    // getters
    public Day getDay() {
        return day;
    }

    public Period getPeriod() {
        return period;
    }

    // will chack if its at the same day or same timeslot
    public boolean isInConflict(Schedule other) {
        return this.day == other.day && this.period == other.period;
    }

    // comparing of schedule objects (gpt'd might need some tweaks once new code is added)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return day == schedule.day && period == schedule.period;
    }

    // quick fix for hashing (gpt'd might need some tweaks once new code is added)
    @Override
    public int hashCode() {
        return Objects.hash(day, period);
    }

    // input to string to print for schedule details
    @Override
    public String toString() {
        return day + " " + period;
    }
}