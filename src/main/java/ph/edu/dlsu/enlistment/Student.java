package ph.edu.dlsu.enlistment;

import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String email;
    private String program;
    private ArrayList<Section> currentClasses =  new ArrayList<Section>();
    private ArrayList<String> completedClasses = new ArrayList<String>();

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student(int id, String name, String email, String program){
        this.id = id;
        this.name = name;
        this.email = email;
        this.program = program;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setCompletedClasses(ArrayList<String> completedClasses) {
        this.completedClasses.clear();
        this.completedClasses.addAll(completedClasses);
    }

    public void setCurrentClasses(ArrayList<Section> currentClasses) {
        this.currentClasses.clear();
        this.currentClasses.addAll(currentClasses);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProgram() {
        return program;
    }

    public ArrayList<Section> getCurrentClasses() {
        return currentClasses;
    }

    public ArrayList<String> getCompletedClasses() {
        return completedClasses;
    }

    //end of getters and setters

    public boolean VerifyClass(Section course) {
        ArrayList<String> prereqs = course.getPrerequisites();
        int n = prereqs.size();
        int o = completedClasses.size();
        int i, j, m = 0, c;

        for (i=0;i<n;i++){
            c=m;
            for(j=0;j<o;j++){
                if (completedClasses.get(j) == prereqs.get(i)){
                    m++;
                }
            }
            if(m == c){
                return false;
            }
        }

        return true;
    }

    public int findCompletedClass(String course){
        int i;
        for(i=0;i<completedClasses.size();i++){
            if(completedClasses.get(i) == course){
                return i;
            }
        }
        return -1;
    }

    public void addCompletedClass(String Course){
        completedClasses.add(Course);
    }

    public void removeCompletedClass(String Course){
        completedClasses.remove(findCompletedClass(Course));
    }

    public int findCurrentClass(Section course){
        int i;
        for(i=0;i<currentClasses.size();i++){
            if(currentClasses.get(i) == course){
                return i;
            }
        }
        return -1;
    }

    public void addCurrentClass(Section Course){
        if(VerifyClass(Course) == true){
            currentClasses.add(Course);
        }
        
    }

    public void removeCurrentClass(Section Course){
        currentClasses.remove(findCurrentClass(Course));
    }
}
