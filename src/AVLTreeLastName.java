import java.util.ArrayList;

public class AVLTreeLastName extends AVLTree<String> {

    public AVLTreeLastName(ArrayList<Student> students) {
        for (Student student : students) {
            this.insertAVL(student.getLastName(), student);
            //System.out.println(student.getLastName() + " Inserted into AVL Tree");
        }
    }

    public AVLTreeLastName() {

    }

    @Override
    public void breadthPrint() {
        super.breadthPrint();
    }
    public ArrayList<Student> getbyName(String name){
        ArrayList<Student> students = new ArrayList<>();
        while(super.isInTree(name)){
            Student currStudent = super.deleteAVL(name);
            students.add(currStudent);
        }
        for(Student student : students){
            this.insertAVL(student.getFirstName(), student);
        }
        return students;
    }
    public void delete(String name, int id){
        ArrayList<Student> students = new ArrayList<>();
        while(super.isInTree(name)){
            Student currStudent = super.deleteAVL(name);
            students.add(currStudent);
        }
        for(Student student : students){
            if(student.getId() != id) {
                this.insertAVL(student.getFirstName(), student);
            }
        }

    }
}
