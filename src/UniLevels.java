import java.util.ArrayList;


public class UniLevels {
    SLL<Student>[] levels = new SLL[]{new SLL<>(), new SLL<>(), new SLL<>(), new SLL<>()};
    String[] labels = {"FR","SO","SR","JR"};//Todo: mapping

    UniLevels(ArrayList<Student> students){
        for(Student student: students){
            System.out.println(student.getUniLevel());
            getList(student).addToHead(student);
        }
    }

    public SLL<Student> getList(String level){
        SLL<Student> l;
        switch (level){
            case "FR" : return levels[0];
            case "SO" : return levels[1];
            case "JR" : return levels[2];
            case "SR" : return levels[3];
            default: return null;
        }
    }
    public SLL<Student> getList(Student student){
        return getList(student.getUniLevel());
    }
    public void delete(Student student){
        getList(student).delete(student);
    }
    public void insert(Student student){
        getList(student).addToTail(student);
    }


}
