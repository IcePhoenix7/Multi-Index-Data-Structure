import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementUI {

    private final MultiIndexStudentManager multiIndexStudentManager;
    private Scanner scanner;

    public StudentManagementUI(MultiIndexStudentManager multiIndexStudentManager) {
        this.scanner = new Scanner(System.in);
        this.multiIndexStudentManager = multiIndexStudentManager;
    }

    public void start() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Search Student");
            System.out.println("2. Add New Student");
            System.out.println("3. Show Students in an Academic Level");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1:
                    searchStudentMenu();
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    showStudentsInLevel();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void searchStudentMenu() {
        System.out.println("\nSearch Student by:");
        System.out.println("1. Student ID");
        System.out.println("2. Last Name");
        System.out.println("3. First Name");
        System.out.print("Enter your choice: ");

        int choice = getValidIntInput();


        Student student = null;

        switch (choice) {
            case 1:
                // TODO: Implement search by ID ✔
                System.out.print("Enter ID: ");
                int id = getValidIntInput();
                student = multiIndexStudentManager.getAvlTreeID().get(id);
                break;
            case 2:
                // TODO: Implement search by Last Name✔
                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine().replace("\n","");
                student = multiIndexStudentManager.getAvlTreeLastName().get(lastName);
                break;
            case 3:
                // TODO: Implement search by First Name✔
                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine().replace("\n","");;
                student = multiIndexStudentManager.getAvlTreeFirstName().get(firstName);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }
        if(student != null){
            System.out.println("\nStudent Found: "+student);
            System.out.println("1. Edit Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");
        }


        int actionChoice = getValidIntInput();
        switch (actionChoice) {
            case 1:
                // TODO: Implement edit student ✔
                editStudent(student);
                break;
            case 2:
                // TODO: Implement delete student
                // Todo: work on validation
                multiIndexStudentManager.delete(student);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void addNewStudent() {
        System.out.println("\nAdding a New Student:");
        System.out.print("Enter Student ID: ");
        int id = getValidIntInput();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Academic Level (FR, SO, JR, SR): ");
        String level = getValidUniversityLevel();

        MyDate birthDate = getValidDateInput();;


        Student newStudent = new Student(id, lastName, firstName, level, birthDate);
        // TODO: Add logic to insert the new student into the data structure
        multiIndexStudentManager.insert(newStudent);
        System.out.println("Student added successfully: " + newStudent);
    }

    private void showStudentsInLevel() {
        System.out.print("\nEnter Academic Level (FR, SO, JR, SR): ");
        String level = getValidUniversityLevel();

        // TODO: Implement logic to show students in a level✔
        ArrayList<Student> students = multiIndexStudentManager.getUniLevels().getList(level);
        System.out.print("Students in level " + level + ": \n"+ students);
    }
    private void editStudent(Student student) {
        while (true) {
            System.out.println("\nEdit Student:");
            System.out.println("1. Edit First Name");
            System.out.println("2. Edit Last Name");
            System.out.println("3. Edit University Level");
            System.out.println("4. Edit Birth Date");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int editChoice = getValidIntInput();

            switch (editChoice) {
                case 1:
                    System.out.print("Enter New First Name: ");
                    String newFirstName = scanner.nextLine();
                    student.setFirstName(newFirstName);
                    System.out.println("First Name updated successfully.");
                    break;
                case 2:
                    System.out.print("Enter New Last Name: ");
                    String newLastName = scanner.nextLine();
                    student.setLastName(newLastName);
                    System.out.println("Last Name updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter New University Level (FR, SO, JR, SR): ");
                    String newUniLevel = getValidUniversityLevel();
                    student.setUniLevel(newUniLevel);
                    System.out.println("University Level updated successfully.");
                    break;
                case 4:
                    MyDate newBirthDate = getValidDateInput();
                    student.setBirthDate(newBirthDate);
                    System.out.println("Birth Date updated successfully.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private int getValidIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }
    private MyDate getValidDateInput() {
        while (true) {
            System.out.print("Enter Date (DD/MM/YYYY): ");
            String dateInput = scanner.nextLine();
            try {
                return new MyDate(dateInput); // Uses the existing MyDate constructor
            } catch (Exception e) {
                System.out.println("Invalid date format or value. Please ensure the format is DD/MM/YYYY.");
            }
        }
    }
    private String getValidUniversityLevel() {
        while (true) {
            System.out.print("Enter Academic Level (FR, SO, JR, SR): ");
            String level = scanner.nextLine().toUpperCase();
            if (level.equals("FR") || level.equals("SO") || level.equals("JR") || level.equals("SR")) {
                return level;
            } else {
                System.out.println("Invalid academic level. Please enter one of the following: FR, SO, JR, SR.");
            }
        }
    }
}
