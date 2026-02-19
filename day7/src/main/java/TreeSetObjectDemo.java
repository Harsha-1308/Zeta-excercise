import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
    int roll;
    int marks;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int compareTo(Student s) {
//        return this.roll - s.roll;
        return this.name.compareTo(s.name);
    }

    public String toString() {
        return roll + " - " + name;
    }
}

class CompareByRoll implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.roll - o2.roll;
    }

}

public class TreeSetObjectDemo {
    public static void main(String[] args) {

        Set<Student> students = new TreeSet<>();

        students.add(new Student(103, "Neha"));
        students.add(new Student(101, "Amit"));
        students.add(new Student(102, "Ravi"));

        System.out.println(students);
        List<Student> list = new ArrayList<Student>(students);
        Collections.sort(list, new CompareByRoll());
        System.out.println(list);
        students = new TreeSet<>(list);
        System.out.println(students);
//        Collections.sort(students, new CompareByRoll());
    }
}