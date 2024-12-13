import java.util.ArrayList;

public class AVLTreeFirstName extends AVLTree<String> {

    public AVLTreeFirstName(ArrayList<Student> students) {
        for (Student student : students) {
            this.insertAVL(student.getFirstName(), student);
            //System.out.println(student.getLastName() + " Inserted into AVL Tree");
        }
    }

    public AVLTreeFirstName() {

    }

    @Override
    public void breadthPrint() {
        super.breadthPrint();
    }
}
