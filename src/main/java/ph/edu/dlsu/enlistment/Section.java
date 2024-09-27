package ph.edu.dlsu.enlistment;

import java.util.ArrayList;

public class Section {

    private String name;
    private String course;
    private ArrayList<String> prerequisites = new ArrayList<String>();
    private ArrayList<Student> Students = new ArrayList<Student>();

    //Optional
    private String room;
    private ArrayList<String> time = new ArrayList<String>();
    private ArrayList<String> days = new ArrayList<String>();
    private int maxCapacity;
    private String professor;

    public Section(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public Section(String name, String course, ArrayList<String> prerequisites) {
        this.name = name;
        this.course = course;
        this.prerequisites = new ArrayList<String>(prerequisites);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPrerequisites(ArrayList<String> prerequisites) {
        this.prerequisites.clear();
        this.prerequisites = new ArrayList<String>(prerequisites);
    }

    public void setStudents(ArrayList<Student> students) {
        this.Students.clear();
        this.Students = new ArrayList<Student>(students);
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTime(ArrayList<String> time) {
        this.time.clear();
        this.time = new ArrayList<String>(time);
    }

    public void setDays(ArrayList<String> days) {
        this.days.clear();
        this.days = new ArrayList<String>(days);
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public ArrayList<Student> getStudents() {
        return Students;
    }

    public String getRoom() {
        return room;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getProfessor() {
        return professor;
    }

    public int StudentCount() {
        return Students.size();
    }

    //end of getters and setters

    public int findStudent(Student target) {
        int i;
        for (i=0; i<Students.size(); i++){
            if (Students.get(i) == target){
                return i;
            }
        }
        return -1;
    }

    public void addStudent(Student student) {
        if (Students.size() < maxCapacity && student.VerifyClass(this) == true){
            Students.add(student);
        }
    }

    public void removeStudent(Student student) {
        Students.remove(findStudent(student));
    }


    public int findPreReq(String target) {
        int i;
        for (i=0; i<prerequisites.size(); i++){
            if (prerequisites.get(i) == target){
                return i;
            }
        }
        return -1;
    }

    public void addPreReq(String course) {
            prerequisites.add(course);
    }

    public void removePreReq(String course) {
        prerequisites.remove(findPreReq(course));
    }



}
