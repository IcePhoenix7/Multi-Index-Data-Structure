public class Student  {//Tode implements Comparable<Student> i had to delete idk why it was there
    private String firstName;
    private String lastName;
    private String uniLevel;
    private int id;
    private MyDate birthDate;


    public Student(String birthDate) {
        if (birthDate != null && !birthDate.startsWith("#")) {
            this.birthDate = new MyDate(birthDate);
        } else {
            this.birthDate = null;
        }
    }

    public Student(int id, String firstName, String lastName, String uniLevel, String birthDate) {
        this(birthDate);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniLevel = uniLevel;
    }

    public Student(int id, String firstName, String lastName, String uniLevel, MyDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniLevel = uniLevel;
        this.id = id;
        this.birthDate = birthDate;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUniLevel(){
        return uniLevel;
    }
    public MyDate getBirthDate(){
        return birthDate;
    }
    public int getYear(){
        return birthDate.getYear();
    }
    public int getMonth(){
        return birthDate.getMonth();
    }
    public int getDay(){
        return birthDate.getDay();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUniLevel(String uniLevel) {
        this.uniLevel = uniLevel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return id + " | " +
                firstName + "  " +
                lastName + " | " +
                birthDate + " | " +
                uniLevel + "\n";
    }
}