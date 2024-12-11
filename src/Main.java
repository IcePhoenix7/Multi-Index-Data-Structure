import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        File file = new File("src/students-trial.csv");
        try (Scanner input = new Scanner(file)){
            int id,age;
            String lastName,firstName,uniLevel,dateOfBirth;
            input.nextLine();
            while (input.hasNext()){
                String[] row = input.nextLine().split(",");
                id = Integer.parseInt(row[0]);
                lastName = row[1];
                firstName = row[2];
                dateOfBirth = row[3];
                uniLevel = row[4];

                Student student = new Student(id,lastName,firstName,uniLevel,dateOfBirth);
                students.add(student);

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(students);

    }
}
