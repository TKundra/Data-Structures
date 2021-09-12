import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    int roll_no;
    String name;

    public Student(String name, int roll_no){
        this.roll_no = roll_no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{ roll_no = " + roll_no + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return roll_no == student.roll_no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll_no);
    }
}

public class CustomDataset {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("a",1));
        set.add(new Student("b",3));
        set.add(new Student("c",2));
        set.add(new Student("d",4));
        // never take same data
        System.out.println(set);
    }
}
