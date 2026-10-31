package Lab_3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Grades {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }
    public void saveToFile(String filePath) {
        List<String> lines = new ArrayList<>();
        for (Student student : students){
            lines.add(student.toString());
        }
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines);
            System.out.println("Данные успешно сохранены в файл: " + filePath);
        } 
        catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    public void loadFromFile(String filePath) {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        try {
            List<String> lines = Files.readAllLines(path);
            students.clear();
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                String name = parts[0];
                List<Integer> gradesList = new ArrayList<>();
                for (int i = 1; i < parts.length; i++){
                    gradesList.add(Integer.parseInt(parts[i].trim()));
                }
                students.add(new Student(name, gradesList));
            }
            System.out.println("Данные успешно загружены из файла!");
        } 
        catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } 
        catch (NumberFormatException e) {
            System.out.println("Ошибка формата данных в файле (нечисловая оценка)!");
        }
    }
}