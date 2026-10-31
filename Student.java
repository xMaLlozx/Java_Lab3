package Lab_3;
import java.util.ArrayList;
import java.util.List;
 
public class Student {
    private String name;
    private List<Integer> grades;
 
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }
 
    public void addGrade(int grade) {
        this.grades.add(grade);
    }
 
    public String getName() {
        return name;
    }
 
    public List<Integer> getGrades() {
        return grades;
    }
 
    public double getAverage() {
        if (grades.isEmpty())
            return 0;
        int sum = 0;
        for (int grade : grades)
            sum += grade;
        return (double) sum / grades.size();
    }
 
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        for (int grade : grades)
            sb.append(",").append(grade);
        return sb.toString();
    }
}