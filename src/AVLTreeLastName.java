import java.util.ArrayList;

public class AVLTreeLastName extends AVLTree<String> {

    public AVLTreeLastName(ArrayList<Student> students) {
        for (Student student : students) {
            this.insertAVL(student.getLastName(), student);
            System.out.println(student.getLastName() + " Inserted into AVL Tree");
        }
    }

    @Override
    public void breadthPrint() {
        super.breadthPrint();
    }
}
