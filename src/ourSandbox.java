import java.io.File;
import java.util.*;

public class ourSandbox {
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
                lastName = row[2];
                firstName = row[1];
                dateOfBirth = row[3];
                uniLevel = row[4].replace("\n","");

                Student student = new Student(id,lastName,firstName,uniLevel,dateOfBirth);
                students.add(student);

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(students);
        AVLTreeLastName avlTreeLastName = new AVLTreeLastName(students);
        System.out.println("############################");
        System.out.println("In-Order Traversal (Alphabetical Order) based on Last Name:");
        avlTreeLastName.inorder();
        System.out.println();
        AVLTreeFirstName avlTreeFirstName = new AVLTreeFirstName(students);
        System.out.println("############################");
        System.out.println("In-Order Traversal (Alphabetical Order) based on First Name:");
        avlTreeFirstName.inorder();
        System.out.println();
        AVLTreeID avlTreeID = new AVLTreeID(students);
        System.out.println("############################");
        System.out.println("In-Order Traversal (Alphabetical Order) based on the ID:");
        avlTreeID.inorder();
        UniLevels uniLevels = new UniLevels(students);
        System.out.println("############################");
        String level = "FR";
        System.out.println("get the list of "+level+" students");
        System.out.println(uniLevels.getList(level));
    }

}